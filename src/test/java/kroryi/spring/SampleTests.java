package kroryi.spring;

import kroryi.spring.dto.Member;
import kroryi.spring.mapper.MemberListMapper;
import kroryi.spring.mapper.TimeMapper;
import kroryi.spring.mapper.TimeMapper2;
import kroryi.spring.service.SampleService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ComponentScan(basePackages = "kroryi.spring")
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTests {
    @Autowired
    private SampleService sampleService;

    @Autowired
    private DataSource dataSource;

    @Autowired(required = false)
    private TimeMapper timeMapper;

    @Autowired(required = false)
    private TimeMapper2 timeMapper2;


    @Autowired(required = false)
    private MemberListMapper memberListMapper;


    @Test
    public void standalone() {
        System.out.println("junit test 실행");
    }

    @Test
    public void testConnection() throws SQLException {
        Connection conn = dataSource.getConnection();
        log.info(conn);
        Assertions.assertNotNull(conn);
        conn.close();
    }

    @Test
    public void testGetTime() {
        log.info(timeMapper.getTime());
        System.out.println(timeMapper.getTime());
    }

    @Test
    public void testGetTime2() {
        log.info(timeMapper2.getNow());
        System.out.println(timeMapper2.getNow());
        System.out.println(timeMapper2.getName());
    }

    @Test
    public void getMemberList() {
        List<Member> memberList = memberListMapper.getMemberList();
        memberList.forEach(member -> {
            System.out.printf(" %s %s %s %s\n",
                    member.getMid(),
                    member.getMname(), member.getMemail(), member.getUuid());
        });
    }

    @Test
    public void getMember() {
        Member member = memberListMapper.selectMember("test03");

        System.out.println(member.toString());
    }

    @Test
    public void InsertMember() {
        Member member = Member.builder()
                .mid("test02")
                .mpw("123456")
                .mname("똥강아지")
                .memail("123456@qq.com")
                .uuid("123456")
                .build();
        memberListMapper.insertMember(member);

    }

    @Test
    public void UpdateMember() {
        Member member = Member.builder()
                .mid("test08")
                .mpw("123456")
                .mname("똥 고양이.")
                .memail("gogogo@qq.com")
                .uuid("123456")
                .build();

        int updateCount = memberListMapper.updateMember(member);
        System.out.println("수정한 개수 : " + updateCount);
    }

    @Test
    public void getMemberWithOrders(){
        Member member = memberListMapper.getMemberWithOrders("test03");
        System.out.println(member.toString());
        member.getOrders().forEach(order -> {
            System.out.println(order.toString());
        });
    }

    @Test
    public void getMemberAllWithOrders(){
        log.info("---------------");
        List<Member> member = memberListMapper.getMemberAllWithOrders("test");
        member.forEach(m -> {
            System.out.println(m.getMid() + " " + m.getMname() + " " + m.getMemail() + " " + m.getUuid());
            m.getOrders().forEach(order -> {
                System.out.print("\t\t");
                System.out.println(order.toString());
            });
        });
    }

}
