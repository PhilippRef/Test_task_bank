package com.example.test.repositories;

import com.example.test.entity.ProductsDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsDB, Integer> {
}
