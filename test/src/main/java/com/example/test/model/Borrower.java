package com.example.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Borrower {
    private Integer id;
    private String name;
    private String lastName;
    private int salary;
    private int claim;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
    private boolean isActive;
    private boolean isDebtor;
}
