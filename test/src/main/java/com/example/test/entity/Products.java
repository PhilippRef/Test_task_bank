package com.example.test.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "amount_of_credit", nullable = false)
    private Integer amountOfCredit;

    @Column(name = "percent", nullable = false)
    private Integer percent;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "last_update_date", nullable = false)
    private LocalDateTime lastUpdateDate;

    @Column(name = "is_active", nullable = false)
    private boolean is_active;
}
