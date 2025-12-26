 package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class BudgetPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private int month;
    private int year;
    private double incomeTarget;
    private double expenseLimit;

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

    // ✅ REQUIRED getters (tests depend on these)
    public Long getId() { return id; }
    public User getUser() { return user; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
    public double getIncomeTarget() { return incomeTarget; }
    public double getExpenseLimit() { return expenseLimit; }

    public void setId(Long id) { this.id = id; }
    public void setUser(User user) { this.user = user; }

    // ✅ Used by summary tests
    public double getTotalAmount() {
        return incomeTarget - expenseLimit;
    }

    // ✅ REQUIRED by validation tests
    public void validate() {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month");
        }
        if (incomeTarget <= 0) {
            throw new IllegalArgumentException("Income must be positive");
        }
        if (expenseLimit < 0) {
            throw new IllegalArgumentException("Expense cannot be negative");
        }
    }
}


// package com.example.demo.model;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.validation.constraints.Size;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.JoinColumn;
// @Entity
// public class BudgetPlan{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
    
//    @ManyToOne
// @JoinColumn(name = "user_id", nullable = false)
// private User user;
//    // @Size(min=1,max=12,message="Follow the constraints ")
//     private int month;
//     private int year;
//     private Double incomeTarget;
//     private Double expenseLimit;
      
//       public  void setId(Long id){
//         this.id=id;
//       }
//       public Long getId(){
//         return id;
//       }
//      public User getUser() {
//     return user;
// }

// public void setUser(User user) {
//     this.user = user;
// }
//       public  void setMonth(int month){
//         this.month=month;
//       }
//       public int getMonth(){
//         return month;
//       }
//       public  void setYear(int year){
//         this.year=year;
//       }
//         public int getYear(){
//         return year;
//       }
//       public  void setIncome(Double incomeTarget){
//         this.incomeTarget=incomeTarget;
//       }
//        public Double getIncome(){
//         return incomeTarget;
//       }
//        public  void setExpense(Double expenseLimit){
//         this.expenseLimit=expenseLimit;
//       }
//       public Double getexpense(){
//         return expenseLimit;
//       }
//       public BudgetPlan(Long id,User user,int month,int year,Double incomeTarget,Double expenseLimit){
//         this.id=id;
//         this.user=user;
//         this.month=month;
//         this.year=year;
//         this.incomeTarget=incomeTarget;
//         this.expenseLimit=expenseLimit;
//       }
//       public BudgetPlan(){

//       }
// }