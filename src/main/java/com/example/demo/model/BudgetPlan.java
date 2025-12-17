package com.example.demo.model;
import jakarta.persistance.Entity;
@Entity
public class BudgetPlan{
    private Long id;
    private String user;
    private int month;
    private int year;
    private Double incomeTarget;
    private Double expenseLimit;
      
      public  void setId(Long id){
        this.id=id;
      }
      public Long getId(){
        return id;
      }
      public void setUser(String user){
        this.user=user;
      }
      public String getUser(){
        return user;
      }
      public  void setMonth(int month){
        this.month=month;
      }
      public int getMonth(){
        return month;
      }
      public  void setYear(int year){
        this.year=year;
      }
        public int getYear(){
        return year;
      }
      public  void setIncome(Double incomeTarget){
        this.incomeTarget=incomeTarget;
      }
       public Double getIncome(){
        return incomeTarget;
      }
       public  void set(Double incomeTarget){
        this.incomeTarget=incomeTarget;
      }
}