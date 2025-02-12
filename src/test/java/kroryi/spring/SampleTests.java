package kroryi.spring;

import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =  "file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTests {

    @Test
    public void standalone() {
        System.out.println("junit test 실행");
    }

}
