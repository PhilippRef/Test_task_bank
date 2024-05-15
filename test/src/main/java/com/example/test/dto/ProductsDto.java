package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductsDto {
    private int id;
    private String name;
    private int amountOfCredit;
    private int percent;
    private int duration;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private boolean isActive;
    private String rulesDto;
}
