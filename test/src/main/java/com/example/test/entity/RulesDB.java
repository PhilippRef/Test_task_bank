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
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "min_salary", nullable = false)
    private Integer minSalary;

    @Column(name = "max_salary", nullable = false)
    private Integer maxSalary;

//    @Column(name = "is_debtor", nullable = false)
//    private boolean isDebtor;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "product_type")
    private ProductsDB productsDB;

//    @OneToOne(mappedBy = "rulesDB", cascade = CascadeType.ALL)
//    private BorrowerDB borrowerDB;


}
