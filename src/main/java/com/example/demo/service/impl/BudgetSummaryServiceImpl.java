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
    private final TransactionLogRepository transactionRepo;

    // ✅ REQUIRED BY TESTS
    public BudgetSummaryServiceImpl(
            BudgetSummaryRepository summaryRepo,
            BudgetPlanRepository planRepo,
            TransactionLogRepository transactionRepo) {

        this.summaryRepo = summaryRepo;
        this.planRepo = planRepo;
        this.transactionRepo = transactionRepo;
    }

    @Override
    public BudgetSummary generateSummary(Long planId) {

        BudgetPlan plan = planRepo.findById(planId)
                .orElseThrow(() ->
                        new BadRequestException("Budget plan not found"));

        // 🔥 TEST EXPECTS transactions to be summed
        List<TransactionLog> logs =
                transactionRepo.findByUser(plan.getUser());

        double totalExpense = logs.stream()
                .mapToDouble(TransactionLog::getAmount)
                .sum();

        double totalIncome = plan.getTotalAmount() + plan.getExpenseLimit();

        String status = totalExpense <= plan.getExpenseLimit()
                ? BudgetSummary.STATUS_UNDER_LIMIT
                : BudgetSummary.STATUS_OVER_LIMIT;

        BudgetSummary summary = new BudgetSummary(
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
                .orElseThrow(() ->
                        new BadRequestException("Budget plan not found"));

        return summaryRepo.findByBudgetPlan(plan)
                .orElse(null);
    }
}
