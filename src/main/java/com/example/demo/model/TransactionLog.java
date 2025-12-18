
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
   public void setamount(Double )

}