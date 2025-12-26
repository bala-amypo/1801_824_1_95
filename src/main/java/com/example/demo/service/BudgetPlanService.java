// package com.example.demo.service;

// import com.example.demo.model.BudgetPlan;

// public interface BudgetPlanService {
//     public BudgetPlan createBudgetPlan(Long userId,BudgetPlan plan);
//     public BudgetPlan getBudgetPlan(Long userId,Integer month,Integer year);
// }
package com.example.demo.service;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;

public interface BudgetPlanService {
    BudgetPlan create(User user, int month, int year, double income);
}
