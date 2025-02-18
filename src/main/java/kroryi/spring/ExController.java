package kroryi.spring;

import kroryi.spring.dto.TodoDTO;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Locale;

@Log4j2
@Controller
public class ExController {

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        // ?dueDate=2025-02-19 문자열 데이터를 LocalDate자동 형변환
        log.info("exe----------> ");
        log.info("dueDate-> {}", dueDate.toString());
        log.info("dueDate-> {}", dueDate.getYear());
        log.info("dueDate-> {}", dueDate.getDayOfMonth());

    }

    @GetMapping("/ex4")
    public String ex4(Model model) {
        log.info("model----------> ");
        model.addAttribute("date", LocalDate.now());
        model.addAttribute("message", "반가워.... 놀아보장.");

        return "/ex/ex4";
    }

    @GetMapping("/ex4_1")
    public void ex4Extra(@ModelAttribute("dto") TodoDTO todoDTO, Model model){
        log.info("dto----------> {}", todoDTO.toString());

    }

    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes, Model model) {
        // GET요청 방식 쿼리 스트링에 포함해서 전달
        redirectAttributes.addAttribute("date", LocalDate.now());
        // 한번만 유지 후 소멸 주로 : 성공, 실패 메세지 전송
        redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/ex6";
    }

    @GetMapping("/ex6")
    public String ex6(Model model) {

        log.info("model----------> {}", model.toString());

        return "/ex/ex6";
    }

}
