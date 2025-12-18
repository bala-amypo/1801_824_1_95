
package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.time.LocalDate;

public class TransactionLog{
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
   private String user;
   private String category;
   private Double amount;
   private String description;
   private LocalDate transactionDate;

   public Long getId(){
    return id;
   }
   public void setId(Long id){
    this.id=id;
   }
   public String getUser(){
    return user;
   }
   public void setuser(String user){
    this.user=user;
   }
   public String getCategory(){
    return category;
   }
   public void setCategory(Strin category){
    this.category=category;

   }
   public Double getAmount(){
    return amount;
   }
   public void setAmount(Double amount){
    this.amount=amount;
   }
   public String getDescription(){
    return description;
   }
   public void setDescription(String description){
    this.description=description;
   }
   public LocalDate getTrans(){
    return transactionDate;
   }
   public void setTrans(LocalDate transactionDate){
    this.transactionDate=transactionDate;
   }
   public TransactionLog(Long id,String user,String category,Double amount,String description,LocalDate transactionDate){
    this.id=id;
    this.user=user;
    this.category=category;
    this.amount=amount;
    this.description
   }

}