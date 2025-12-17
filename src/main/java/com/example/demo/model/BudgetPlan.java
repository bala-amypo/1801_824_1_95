package com.example.demo.model;
import jakarta.persistance.Entity;
@Entity
public class BudgetPlan{
    private int id;
    private String user;
    private int month;
    private int year;
    private Double incomeTarget;
    private Double expenseLimit;
      
      public  void setId(int id){
        this.id=id;
      }
      public int getId(){
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
      
      
}