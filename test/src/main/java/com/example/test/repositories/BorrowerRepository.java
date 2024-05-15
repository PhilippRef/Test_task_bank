package com.example.test.repositories;

import com.example.test.entity.BorrowerDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends JpaRepository<BorrowerDB, Integer> {
}
