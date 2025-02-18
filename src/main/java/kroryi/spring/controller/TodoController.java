package kroryi.spring.controller;

import kroryi.spring.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {

    @GetMapping("/list")
    public void list() {
        log.info("todo 목록보기");
    }

    @GetMapping("/register")
    public String registerGet() {
        log.info("GET todo 등록 페이지 보여주기....");
        return "/todo/todoRegister";
    }


//        @ModelAttribute("dto") 하면 model 별도로 todoDTO를 등록을 않하고 바로
//        jsp에서 ${dto}로 사용 할 수 있다.
    @PostMapping("/register")
    public String registerPost(@ModelAttribute("dto") TodoDTO todoDTO, Model model){
        log.info("POST todo 등록....");
        log.info(todoDTO.toString());
//        model.addAllAttributes("dto", todoDTO);

        return "/todo/todoTest";
    }
}
