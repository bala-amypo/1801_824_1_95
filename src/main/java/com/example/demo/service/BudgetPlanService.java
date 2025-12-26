// package com.example.demo.service;

// import com.example.demo.model.BudgetPlan;

// public interface BudgetPlanService {
//     public BudgetPlan createBudgetPlan(Long userId,BudgetPlan plan);
//     public BudgetPlan getBudgetPlan(Long userId,Integer month,Integer year);
// }
package com.example.demo.service;

import com.example.demo.model.BudgetPlan;

public interface BudgetPlanService {

    BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan);

    BudgetPlan getBudgetPlan(Long userId, Integer month, Integer year);
}
