package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    // 🔑 REQUIRED BY TEST
    public static final String TYPE_INCOME = "INCOME";
    public static final String TYPE_EXPENSE = "EXPENSE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    // ✅ REQUIRED: no-arg constructor
    public Category() {}

    // ✅ REQUIRED: constructor used in tests
    public Category(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // ✅ Getters & Setters (tests use setters)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // TEST USES setId()
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // ✅ REQUIRED BY SERVICE
    public void validateType() {
        if (!TYPE_INCOME.equals(type) && !TYPE_EXPENSE.equals(type)) {
            throw new RuntimeException("Invalid category type");
        }
    }
}


// package com.example.demo.model;
// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Column;

// @Entity
// public class Category{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     @Column(unique=true)
//     private String name;
//     private String type;

//     public Long getId(){
//         return id;
//     }
//     public  void setId(Long id){
//         this.id=id;
//     }
//     public String getName(){
//         return name;
//     }
//     public void setName(String name){
//         this.name=name;
//     }
//     public String getType(){
//         return type;
//     }
//     public void setType(String type){
//         this.type=type;
//     }
//     public Category(Long id,String name,String type){
//         this.id=id;
//         this.name=name;
//         this.type=type;
//     }
//     public Category(){

//     }
// }