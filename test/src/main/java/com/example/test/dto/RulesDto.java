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
    private int id;
    private String name;
    private String productDB;
    private int minSalary;
    private int maxSalary;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private boolean isActive;
}
