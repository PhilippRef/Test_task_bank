package com.example.test.repositories;

import com.example.test.entity.ProductsDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsDB, Integer> {
    @Query("SELECT p FROM ProductsDB p WHERE p.name = ?1")
    ProductsDB findByName(String name);
}
