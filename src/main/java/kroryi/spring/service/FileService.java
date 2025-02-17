package kroryi.spring.service;


import kroryi.spring.dto.EmployeeImageDTO;
import kroryi.spring.mapper.EmployeeImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {
    private final String uploadDir = "upload";
    @Autowired
    private EmployeeImageMapper mapper;

    public void uploadImage(int employeeId, MultipartFile file) throws IOException {
        EmployeeImageDTO employeeImageDTO = EmployeeImageDTO.builder()
                .employeeId(employeeId)
                .imageName(file.getOriginalFilename())
                .imageType(file.getContentType())
                .imageData(file.getBytes())
                .build();

        mapper.uploadImage(employeeImageDTO);

    }
}
