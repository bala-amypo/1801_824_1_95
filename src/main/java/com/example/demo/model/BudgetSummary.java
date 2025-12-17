package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.time.LocalDateTime;
@Entity
public class BudgetSummary{
    
    @Id
    private Long id;
    private String budgetPlan;
    private Double totalIncome;
    private Double totalExpense;
    private String status;
    private LocalDateTime generatedAt;

    public getId(){
        return id;

    }
    public setId(Long id){
        this.id=id;
    }
    public getPlan(){
        return budgetPlan;
    }
    public setPlan(String budgetPlan){
        this budgetPlan=budgetPlan;
    }
    public getTotal(){
        return totalIncome;
    }
    
}
