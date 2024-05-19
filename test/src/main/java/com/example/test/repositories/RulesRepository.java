package com.example.test.repositories;

import com.example.test.entity.RulesDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RulesRepository extends JpaRepository<RulesDB, Integer> {
}
