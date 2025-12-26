 package com.example.demo.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.BudgetPlan;
import com.example.demo.model.BudgetSummary;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.BudgetSummaryService;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository summaryRepo;
    private final BudgetPlanRepository planRepo;
    private final TransactionLogRepository logRepo; // ✅ REQUIRED

    // ✅ TEST EXPECTS THIS EXACT CONSTRUCTOR (3 args)
    public BudgetSummaryServiceImpl(BudgetSummaryRepository summaryRepo,
                                    BudgetPlanRepository planRepo,
                                    TransactionLogRepository logRepo) {
        this.summaryRepo = summaryRepo;
        this.planRepo = planRepo;
        this.logRepo = logRepo;
    }

    @Override
    public BudgetSummary generateSummary(Long planId) {

        BudgetPlan plan = planRepo.findById(planId)
                .orElseThrow(() -> new BadRequestException("Budget plan not found"));

        double totalIncome = plan.getIncomeTarget();
        double totalExpense = plan.getExpenseLimit();

        String status = totalExpense <= totalIncome
                ? BudgetSummary.STATUS_UNDER_LIMIT
                : BudgetSummary.STATUS_OVER_LIMIT;

        BudgetSummary summary = new BudgetSummary(
                null,
                plan,
                totalIncome,
                totalExpense,
                status,
                LocalDateTime.now()
        );

        return summaryRepo.save(summary);
    }

    @Override
    public BudgetSummary getSummary(Long planId) {

        BudgetPlan plan = planRepo.findById(planId)
                .orElseThrow(() -> new BadRequestException("Budget plan not found"));

        return summaryRepo.findByBudgetPlan(plan).orElse(null);
    }
}
