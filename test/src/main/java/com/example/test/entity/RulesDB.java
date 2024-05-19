package com.example.test.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "rules")
@NoArgsConstructor
@Data
public class RulesDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "rule_name", nullable = false)
    private String name;

    @Column(name = "borrower_salary", nullable = false)
    private Integer borrowerSalary;

    @Column(name = "is_borrower_debtor", nullable = false)
    private boolean isBorrowerDebtor;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "product_type")
    private ProductsDB productsDB;

}
