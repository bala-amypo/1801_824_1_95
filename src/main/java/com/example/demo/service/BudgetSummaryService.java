package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.BudgetSummary;
public interface BudgetSummaryService {
    public BudgetSummary generateSummary(Long userId,BudgetPlan plan);
    public BudgetSummary getSummary(Long userId,Integer month,Integer year);
}