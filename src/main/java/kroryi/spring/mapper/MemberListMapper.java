package kroryi.spring.mapper;

import java.util.List;
import kroryi.spring.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberListMapper {
    List<Member> getMemberList();

    Member selectMember(String mid);

    void insertMember(Member member);

    int updateMember(Member member);


    Member getMemberWithOrders(String mid);
    List<Member> getMemberAllWithOrders(String mid);


}
