package kroryi.spring.controller;

import jakarta.validation.Valid;
import kroryi.spring.dto.TodoDTO;
import kroryi.spring.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @GetMapping("/list")
    public String list() {
        log.info("todo 목록보기");
        return "/todo/todoList";
    }

    @GetMapping("/register")
    public String registerGet() {
        log.info("GET todo 등록 페이지 보여주기....");
        return "/todo/todoRegister";
    }

    @PostMapping("/register")
    public String registerPost(
            @Valid TodoDTO todoDTO,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes){
        log.info("POST todo 등록....");
        log.info(todoDTO.toString());

        if(bindingResult.hasErrors()) {
            log.error("binding 에러 발생.. ");
            String messageError = bindingResult.getFieldError().getField();
//            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addFlashAttribute("errors", messageError +"을(를) 채우세요.");
            return "redirect:/todo/register";
        }
        service.register(todoDTO);

        return "/todo/todoList";
    }
}
