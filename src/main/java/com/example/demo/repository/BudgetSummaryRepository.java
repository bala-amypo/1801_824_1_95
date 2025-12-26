// package com.example.demo.repository;
// import com.example.demo.model.BudgetSummary;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.BudgetSummary;

// public interface BudgetSummaryRepository extends JpaRepository<BudgetSummary,Long>{
      
// }
package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.BudgetSummary;

public interface BudgetSummaryRepository extends JpaRepository<BudgetSummary, Long> {
    Optional<BudgetSummary> findByBudgetPlanId(Long budgetPlanId);
}
