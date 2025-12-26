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

        // 🔥 FIXED CONSTRUCTOR CALL
        BudgetSummary summary = new BudgetSummary(
                null,
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

        return summaryRepo.findByBudgetPlan(plan)
                .orElse(null);
    }
}


// package com.example.demo.model;
// import com.example.demo.model.BudgetPlan;
// import jakarta.persistence.Entity;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.Id;
// import java.time.LocalDateTime;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// @Entity
// public class BudgetSummary{
    
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     @OneToOne
//     @JoinColumn(name = "budgetplan_id")
//     private BudgetPlan budgetPlan;
//     private Double totalIncome;
//     private Double totalExpense;
//     private String status;
//     private LocalDateTime generatedAt;

//     public Long getId(){
//         return id;

//     }
//     public  void setId(Long id){
//         this.id=id;
//     }
//       public BudgetPlan getBudgetPlan() {
//         return budgetPlan;
//     }

//     public void setBudgetPlan(BudgetPlan budgetPlan) {
//         this.budgetPlan = budgetPlan;
//     }
//     public  Double getTotal(){
//         return totalIncome;
//     }
//     public void setTotal(Double totalIncome){
//         this.totalIncome=totalIncome;
// }
//     public Double getExpense(){
//         return totalExpense;
//     }
//     public void setExpense(Double totalExpense){
//          this.totalExpense=totalExpense;
//     }
//     public String getStatus(){
//         return status;
//     }
//     public void setStatus(String status){
//         this.status=status;
//     }
//     public LocalDateTime getGenerate(){
//         return generatedAt;
//     }
//     public void setGenerate(LocalDateTime generatedAt){
//         this.generatedAt=generatedAt;
//     }
//     public BudgetSummary(Long id,BudgetPlan budgetPlan,Double totalIncome,Double totalExpense,String status,LocalDateTime generatedAt){
//         this.id=id;
//         this.budgetPlan=budgetPlan;
//         this.totalIncome=totalIncome;
// this.totalExpense=totalExpense;
// this.status=status;
// this.generatedAt=generatedAt;
//     }
//     public BudgetSummary(){
        
//     }


    
// }
