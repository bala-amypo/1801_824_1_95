package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import jakarta.persistence.*;

@Entity
public class BudgetPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private User user;

    private int month;
    private int year;
    private double incomeTarget;
    private double expenseLimit;

    // ----- Constructors -----
    public BudgetPlan() {}

    public BudgetPlan(Long id, User user, int month, int year,
                      double incomeTarget, double expenseLimit) {
        this.id = id;
        this.user = user;
        this.month = month;
        this.year = year;
        this.incomeTarget = incomeTarget;
        this.expenseLimit = expenseLimit;
    }

    // ----- Getters -----
    public Long getId() { return id; }
    public User getUser() { return user; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
    public double getIncomeTarget() { return incomeTarget; }
    public double getExpenseLimit() { return expenseLimit; }

    // ----- Setters -----
    public void setId(Long id) { this.id = id; }
    public void setUser(User user) { this.user = user; }
    public void setIncomeTarget(double incomeTarget) { this.incomeTarget = incomeTarget; }
    public void setExpenseLimit(double expenseLimit) { this.expenseLimit = expenseLimit; }

    // ----- Business Logic -----
    public void validate() {
        if (month < 1 || month > 12) {
            throw new BadRequestException("Invalid month");
        }
        if (incomeTarget < 0 || expenseLimit < 0) {
            throw new BadRequestException("Amounts cannot be negative");
        }
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
