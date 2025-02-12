package kroryi.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class TestController {

    @GetMapping("/write") // /board/test
    public String test() {

        SampleService service = new SampleService();

        return "test";
    }

    @PostMapping("/writer")
    public String board_write() {
        return "board_write";
    }
}
