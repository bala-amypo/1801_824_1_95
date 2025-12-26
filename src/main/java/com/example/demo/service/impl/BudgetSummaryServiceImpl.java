package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

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

    // ✅ CONSTRUCTOR EXPECTED BY TEST
    public BudgetSummaryServiceImpl(
            BudgetSummaryRepository summaryRepo,
            BudgetPlanRepository planRepo,
            TransactionLogRepository transactionRepo) {

        this.summaryRepo = summaryRepo;
        this.planRepo = planRepo;
        this.transactionRepo = transactionRepo;
    }

    @Override
    public BudgetSummary generateSummary(Long budgetPlanId) {

        BudgetPlan plan = planRepo.findById(budgetPlanId)
                .orElseThrow(() -> new RuntimeException("Budget plan not found"));

        List<TransactionLog> transactions =
                transactionRepo.findByUserAndTransactionDateBetween(
                        plan.getUser(),
                        LocalDate.of(plan.getYear(), plan.getMonth(), 1),
                        LocalDate.of(plan.getYear(), plan.getMonth(), 28)
                );

        double totalExpense = transactions.stream()
                .mapToDouble(TransactionLog::getAmount)
                .sum();

        BudgetSummary summary = new BudgetSummary();
        summary.setBudgetPlan(plan);
        summary.setTotalExpense(totalExpense);

        summary.setStatus(
                totalExpense <= plan.getTotalAmount()
                        ? BudgetSummary.STATUS_UNDER_LIMIT
                        : BudgetSummary.STATUS_OVER_LIMIT
        );

        return summaryRepo.save(summary);
    }

    @Override
    public BudgetSummary getSummary(Long budgetPlanId) {
        BudgetPlan plan = planRepo.findById(budgetPlanId)
                .orElseThrow(() -> new RuntimeException("Budget plan not found"));

        return summaryRepo.findByBudgetPlan(plan)
                .orElseThrow(() -> new RuntimeException("Summary not found"));
    }
}
