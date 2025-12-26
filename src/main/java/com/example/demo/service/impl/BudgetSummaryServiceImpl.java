package com.example.demo.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.BudgetPlan;
import com.example.demo.model.BudgetSummary;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.service.BudgetSummaryService;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository summaryRepo;
    private final BudgetPlanRepository planRepo;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository summaryRepo,
                                    BudgetPlanRepository planRepo) {
        this.summaryRepo = summaryRepo;
        this.planRepo = planRepo;
    }

    @Override
    public BudgetSummary generateSummary(Long planId) {

        BudgetPlan plan = planRepo.findById(planId)
                .orElseThrow(() ->
                        new BadRequestException("Budget plan not found"));

        double income = plan.getTotalAmount() + plan.getExpenseLimit();
        double expense = plan.getExpenseLimit();

        String status = expense <= plan.getExpenseLimit()
                ? BudgetSummary.STATUS_UNDER_LIMIT
                : BudgetSummary.STATUS_OVER_LIMIT;

        BudgetSummary summary = new BudgetSummary(
                plan,
                income,
                expense,
                status,
                LocalDateTime.now()
        );

        return summaryRepo.save(summary);
    }

    @Override
    public BudgetSummary getSummary(Long planId) {

        BudgetPlan plan = planRepo.findById(planId)
                .orElseThrow(() ->
                        new BadRequestException("Budget plan not found"));

        return summaryRepo.findByBudgetPlan(plan);
    }
}
