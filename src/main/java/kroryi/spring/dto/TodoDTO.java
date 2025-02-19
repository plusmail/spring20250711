package kroryi.spring.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {

    private Long tno;
    @NotEmpty
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    @NotEmpty
    private String writer;
}
