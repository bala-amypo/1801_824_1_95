package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class BudgetPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private Integer month;
    private Integer year;
    private Double incomeTarget;
    private Double expenseLimit;

    public BudgetPlan() {}

    public BudgetPlan(Long id, User user, Integer month, Integer year,
                      Double incomeTarget, Double expenseLimit) {
        this.id = id;
        this.user = user;
        this.month = month;
        this.year = year;
        this.incomeTarget = incomeTarget;
        this.expenseLimit = expenseLimit;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Integer getMonth() { return month; }
    public void setMonth(Integer month) { this.month = month; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public Double getIncomeTarget() { return incomeTarget; }
    public void setIncomeTarget(Double incomeTarget) { this.incomeTarget = incomeTarget; }

    public Double getExpenseLimit() { return expenseLimit; }
    public void setExpenseLimit(Double expenseLimit) { this.expenseLimit = expenseLimit; }
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