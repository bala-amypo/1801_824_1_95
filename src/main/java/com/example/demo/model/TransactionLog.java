package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    // ✅ REQUIRED CONSTRUCTOR (tests use it)
    public UserServiceImpl(UserRepository repo,
                           PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {

        if (repo.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");

        return repo.save(user);
    }

    // ✅ MUST match interface exactly
    @Override
    public User getByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
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