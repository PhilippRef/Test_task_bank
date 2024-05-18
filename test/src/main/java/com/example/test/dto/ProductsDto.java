package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductsDto {
    private Integer id;
    private String name;
    private int amountOfCredit;
    private int percent;
    private int duration;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private boolean isActive;
    private List<RulesDto> rules;
}
