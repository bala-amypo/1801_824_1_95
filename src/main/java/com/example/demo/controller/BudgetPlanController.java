package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.BudgetPlan;
import com.example.demo.service.BudgetPlanService;

@RestController
@RequestMapping("/budgetplan")
public class BudgetPlanController {

    @Autowired
    private BudgetPlanService budgetPlanService;

    // CREATE BudgetPlan
    // POST /budgetplan/{userId}
    @PostMapping("/{userId}")
    public BudgetPlan createBudgetPlan(
            @PathVariable Long userId,
            @RequestBody BudgetPlan plan) {

        return budgetPlanService.createBudgetPlan(userId, plan);
    }

    // GET BudgetPlan by user + month + year
    // GET /budgetplan/{userId}/{month}/{year}
    @GetMapping("/{userId}/{month}/{year}")
    public BudgetPlan getBudgetPlan(
            @PathVariable Long userId,
            @PathVariable Integer month,
            @PathVariable Integer year) {

        return budgetPlanService.getBudgetPlan(userId, month, year);
    }
}
