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

    public int getId(){
        return id;

    }
    public  void setId(Long id){
        this.id=id;
    }
    public  getPlan(){
        return budgetPlan;
    }
    public setPlan(String budgetPlan){
        this budgetPlan=budgetPlan;
    }
    public getTotal(){
        return totalIncome;
    }
    public setTotal(Double totalIncome){
        this.totalIncome=totalIncome;
}
    public getExpense(){
        return totalExpense;
    }
    public setExpense(Double totalExpense){
         this.totalExpense=totalExpense;
    }
    public getStatus(){
        return status;
    }
    public setStatus(String status){
        this.status=status;
    }
    public getGenerate(){
        return LocalDateTime;
    }
    public setGenerate(LocalDateTime generatedAt){
        this.generatedAt=generatedAt;
    }
    public BudgetSummary(Long id,String budgetPlan,Double totalIncome,Double totalExpense,String status,LocalDateTime generatedAt){
        this.id=id;
        this budgetPlan=budgetPlan;
        this.totalIncome=totalIncome;
this.totalExpense=totalExpense;
this.status=status;
this.generatedAt=generatedAt;
    }
    public BudgetSummary(){
        
    }


    
}
