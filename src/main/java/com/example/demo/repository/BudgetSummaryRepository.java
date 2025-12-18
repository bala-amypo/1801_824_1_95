package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.BudgetSummary;

public interface BudgetSummaryRepository extends JpaRepository<User,Long>{
      
}