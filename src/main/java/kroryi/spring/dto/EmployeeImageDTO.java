package kroryi.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
