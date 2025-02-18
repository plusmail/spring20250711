package kroryi.spring.controller;

import kroryi.spring.dto.EmployeeImageDTO;
import kroryi.spring.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.util.List;

@Log4j2
@Controller
@RequestMapping("/image")
@RequiredArgsConstructor
@EnableWebMvc
public class ImageController {

    private final FileService service;

//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadImage(@RequestParam("employeeId") int employeeId,@RequestParam("file") MultipartFile file) {
//
//        try{
//            service.uploadImage(employeeId, file);
//            return ResponseEntity.ok("이미지 업로드 성공!!!!");
//        }catch (Exception e){
//            return ResponseEntity.internalServerError().body("이미지 업로드 실패!!!!");
//        }
//    }

    @RequestMapping(value="/upload", method = RequestMethod.GET)
    public String uploadForm(){
        return "uploadForm";
    }

    // spring 4.3 (2016부터 사용)
    @PostMapping("/upload")
    public String uploadFile(
            @RequestParam("employeeId") int employeeId,
            @RequestParam("file") MultipartFile file,
            Model model) throws IOException {

        try{
            service.uploadImage(employeeId, file);
            model.addAttribute("message", "파일 업로드 성공" + file.getOriginalFilename());
            return "uploadSuccess";

        }catch (Exception e){
            model.addAttribute("message", "파일 업로드 실패");
            return "uploadFailure";
        }
    }

    @GetMapping("/{id}")
    public String viewImage(@PathVariable int id, Model model) {
        EmployeeImageDTO dto = service.getImageById(id);
        model.addAttribute("dto", dto);

        return "imageView";
    }

    @GetMapping("/list/{employeeId}")
    public String viewImageList(@PathVariable int employeeId, Model model) {
        List<EmployeeImageDTO> dto = service.getImageByEmployeeId(employeeId);
        model.addAttribute("dto", dto);

        return "imageList";
    }


}
