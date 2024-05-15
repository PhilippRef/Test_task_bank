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
public class BorrowerDto {
    private int id;
    private String name;
    private String lastName;
    private int salary;
    private int claim;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;
    private boolean is_active;
    private boolean is_debtor;
}
