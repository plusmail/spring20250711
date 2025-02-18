package kroryi.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeImageDTO {
    private int id;
    private byte[] imageData;
    private String imageName;
    private String imageType;
    private int employeeId;

    // Base64 인코딩 디코딩 방식
    // 바이러니 데이터를 ASCII 문자열로 변환하는 인코딩
    // 이미지, 파일, 동영상
    //010011 → T
    //010110 → W
    //000101 → F
    //101110 → u
    public String getImageDataBase64() {
        return (imageData != null) ? Base64.getEncoder().encodeToString(imageData) : null;
    }
}
