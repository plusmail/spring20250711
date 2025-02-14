package kroryi.spring.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {
    private int eno;
    private String ename;
    private int salary;
    private int gender;
    private LocalDate joinDate;
    private DepartmentDTO fk_department;
    private List<TitleDTO> fk_title;
}
