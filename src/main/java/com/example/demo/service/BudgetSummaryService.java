package com.example.demo.service;
 import com.example.demo.model.BudgetPlan;
import com.example.demo.model.BudgetSummary;
 
public interface BudgetSummaryService {
    public BudgetSummary generateSummary(BudgetPlan budgetPlanId);
    public BudgetSummary getSummary(BudgetPlan budgetPlanId);
}