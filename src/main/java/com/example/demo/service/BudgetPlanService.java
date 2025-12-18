package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.BudgetPlan;
@Service
public interface BudgetPlanService {
    public BudgetPlan createBudgetPlan(Long userId,BudgetPlan plan);
    public BudgetPlan getBudgetPlan(Long userId,Integer month,Integer year);
}