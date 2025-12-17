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
      
      
}