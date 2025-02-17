package kroryi.spring.controller;

import kroryi.spring.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/image")
@RequiredArgsConstructor
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

    @GetMapping("/upload")
    public String uploadForm(){
        return "uploadForm";
    }

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

}
