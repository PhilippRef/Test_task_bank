package com.example.test.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "borrower")
@NoArgsConstructor
@Data
public class BorrowerDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "name", nullable = false)
    private String lastName;

    @Column(name = "salary", nullable = false)
    private Integer salary;

    @Column(name = "claim", nullable = false) //сумма заема
    private Integer claim;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "last_update_date", nullable = false)
    private LocalDateTime lastUpdateDate;

    @Column(name = "is_active", nullable = false)
    private boolean is_active;

    @Column(name = "is_debtor", nullable = false)
    private boolean is_debtor;
}
