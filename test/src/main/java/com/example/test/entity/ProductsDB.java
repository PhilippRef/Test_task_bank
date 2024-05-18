package com.example.test.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Data
public class ProductsDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "amount_of_credit", nullable = false)
    private Integer amountOfCredit;

    @Column(name = "percent", nullable = false)
    private Integer percent;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @OneToMany(mappedBy = "productsDB", cascade = CascadeType.ALL)
    private List<RulesDB> rulesDB;
}
