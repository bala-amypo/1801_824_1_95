// package com.example.demo.repository;
// import com.example.demo.model.BudgetSummary;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.BudgetSummary;

// public interface BudgetSummaryRepository extends JpaRepository<BudgetSummary,Long>{
      
// }
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.BudgetSummary;
import com.example.demo.model.BudgetPlan;

 import java.util.Optional;

public interface BudgetSummaryRepository
        extends JpaRepository<BudgetSummary, Long> {

    Optional<BudgetSummary> findByBudgetPlan(BudgetPlan plan);
}

