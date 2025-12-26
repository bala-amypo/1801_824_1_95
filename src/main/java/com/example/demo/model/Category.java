package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    public static final String ROLE_USER = "USER";
    public static final String ROLE_ADMIN = "ADMIN";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String role;

    public User() {}

    public User(Long id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
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