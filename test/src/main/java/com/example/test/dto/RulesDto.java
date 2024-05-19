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
public class RulesDto {
    private Integer id;
    private String name;
    private int borrowerSalary;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private boolean isActive;
    private boolean isBorrowerDebtor;
    private String productDB;
}
