package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    // Expected values: INCOME or EXPENSE
    @Column(nullable = false)
    private String type;

    // ---------------- CONSTRUCTORS ----------------

    public Category() {
    }

    public Category(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // ---------------- GETTERS & SETTERS ----------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    // ---------------- VALIDATION METHOD ----------------
    // REQUIRED because CategoryServiceImpl calls validateType()

    public void validateType() {
        if (type == null) {
            throw new RuntimeException("Category type cannot be null");
        }

        if (!type.equalsIgnoreCase("INCOME") &&
            !type.equalsIgnoreCase("EXPENSE")) {
            throw new RuntimeException(
                "Category type must be either INCOME or EXPENSE"
            );
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