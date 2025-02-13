package kroryi.spring.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Order {
    private Long id;
    private String mid;
    private String productName;
    private LocalDate orderDate;
}
