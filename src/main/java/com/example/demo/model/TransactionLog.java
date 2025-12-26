package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.example.demo.exception.BadRequestException;

@Entity
public class TransactionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;

    private Double amount;
    private String description;
    private LocalDate transactionDate;

    public TransactionLog() {}

    public TransactionLog(Long id, User user, Category category,
                          Double amount, String description, LocalDate transactionDate) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.transactionDate = transactionDate;
    }

    public void validate() {
        if (amount <= 0)
            throw new BadRequestException("Amount must be positive");
        if (transactionDate.isAfter(LocalDate.now()))
            throw new BadRequestException("Future date not allowed");
    }

    public void setUser(User user) { this.user = user; }
    public Long getId() { return id; }
    public User getUser() { return user; }
    public Category getCategory() { return category; }
    public Double getAmount() { return amount; }
}

// package com.example.demo.model;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Column;
// import java.time.LocalDate;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.JoinColumn;

// @Entity
// public class TransactionLog{
//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Long id;
//     @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

//    @ManyToOne
//    @JoinColumn(name = "category_id", nullable = false)
//    private Category category;
//    private Double amount;
//    private String description;
//    private LocalDate transactionDate;

//    public Long getId(){
//     return id;
//    }
//    public void setId(Long id){
//     this.id=id;
//    }
//    public User getUser(){
//     return user;
//    }
//    public void setUser(User user){
//     this.user=user;
//    }
//    public Category getCategory(){
//     return category;
//    }
//    public void setCategory(Category category){
//     this.category=category;

//    }
//    public Double getAmount(){
//     return amount;
//    }
//    public void setAmount(Double amount){
//     this.amount=amount;
//    }
//    public String getDescription(){
//     return description;
//    }
//    public void setDescription(String description){
//     this.description=description;
//    }
//    public LocalDate getTrans(){
//     return transactionDate;
//    }
//    public void setTrans(LocalDate transactionDate){
//     this.transactionDate=transactionDate;
//    }
//    public TransactionLog(Long id,User user,Category category,Double amount,String description,LocalDate transactionDate){
//     this.id=id;
//     this.user=user;
//     this.category=category;
//     this.amount=amount;
//     this.description=description;
//     this.transactionDate=transactionDate;
//    }
//    public TransactionLog(){

//    }

// }