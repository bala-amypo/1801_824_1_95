
package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import 

public class TransactionLog{
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
   private String user;
   private String category;
   private Double amount;
   private String description;
   private Localtime transactionDate;

}