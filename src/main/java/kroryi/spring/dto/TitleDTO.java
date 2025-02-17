package kroryi.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TitleDTO {
    private int code;
    private String name;
//    private int fk_eno;
}
