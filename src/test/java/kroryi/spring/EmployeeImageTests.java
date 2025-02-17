package kroryi.spring;


import kroryi.spring.dto.EmployeeImageDTO;
import kroryi.spring.mapper.EmployeeImageMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.file.Paths;

import java.io.*;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class EmployeeImageTests {

    @Autowired
    private EmployeeImageMapper employeeImageMapper;
    private final String testFileName = "/upload/";

    @BeforeEach
    void setUp() {
        File file = new File(testFileName);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @Test
    public void uploadImage() {
        String absolutePath = Paths.get("").toAbsolutePath().toString() + File.separator + testFileName;
        File file = new File(absolutePath + "test.png");
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            System.out.println(file.getName());

            EmployeeImageDTO employeeImageDTO = EmployeeImageDTO.builder()
                    .imageName(file.getName())
                    .imageData(bos.toByteArray())
                    .imageType("image/png")
                    .employeeId(1)
                    .build();
            employeeImageMapper.uploadImage(employeeImageDTO);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
