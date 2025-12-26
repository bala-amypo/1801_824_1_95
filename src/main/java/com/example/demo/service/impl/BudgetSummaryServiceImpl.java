 package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.BudgetPlan;
import com.example.demo.model.BudgetSummary;
import com.example.demo.model.TransactionLog;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.BudgetSummaryService;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository summaryRepo;
    private final BudgetPlanRepository planRepo;
    private final TransactionLogRepository logRepo;

    // ✅ REQUIRED constructor (TEST EXPECTS THIS)
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
                .orElseThrow(() ->
                        new BadRequestException("Budget plan not found"));

        List<TransactionLog> logs = logRepo.findByUser(plan.getUser());

        double income = 0;
        double expense = 0;

        for (TransactionLog log : logs) {
            if ("INCOME".equals(log.getCategory().getType())) {
                income += log.getAmount();
            } else {
                expense += log.getAmount();
            }
        }

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

        return summaryRepo.findByBudgetPlan(plan).orElse(null);
    }
}
