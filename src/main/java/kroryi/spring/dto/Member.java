package kroryi.spring.dto;

import lombok.*;

import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Member {

    private String mid;
    private String mpw;
    private String mname;
    private String memail;
    private String uuid;
    private List<Order> orders;
    private List<Option> options;
}
