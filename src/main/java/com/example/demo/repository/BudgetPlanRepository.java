// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.BudgetPlan;
// import java.util.Optional;
// public interface BudgetPlanRepository extends JpaRepository<BudgetPlan,Long>{
//     Optional<BudgetPlan> findByUserIdAndMonthAndYear(
//             Long userId,
//             Integer month,
//             Integer year
//     );
// }
package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.BudgetPlan;

public interface BudgetPlanRepository extends JpaRepository<BudgetPlan, Long> {
    Optional<BudgetPlan> findByUserIdAndMonthAndYear(Long userId, Integer month, Integer year);
}
