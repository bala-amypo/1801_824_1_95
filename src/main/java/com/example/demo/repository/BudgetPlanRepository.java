package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.BudgetPlan;
import java.util.List;
public interface BudgetPlanRepository extends JpaRepository<BudgetPlan,Long>{
    List<BudgetPlan> findByUserIdAndMonthAndYear(
            Long userId,
            Integer month,
            Integer year
    );
}