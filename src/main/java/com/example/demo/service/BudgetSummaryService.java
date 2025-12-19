package com.example.demo.service;
 
import com.example.demo.model.BudgetSummary;
 
public interface BudgetSummaryService {
    public BudgetSummary generateSummary(Long budgetPlanId);
    public BudgetSummary getSummary(Long budgetPlanId);
}