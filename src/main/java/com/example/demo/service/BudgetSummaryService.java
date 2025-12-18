package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.BudgetSummary;
@Service
public interface BudgetSummaryService {
    public BudgetSummary generateSummary(Long budgetPlanId);
    public BudgetSummary getSummary(Long budgetPlanId);
}