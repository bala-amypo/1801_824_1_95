package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;
import jakarta.persistence.Column;

@Entity
public class Category{
    @Id
    @GeneratedValue(strategy=GeneratedType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String name;
    private String type;

    public void getId(){
        return id;
    }
    public  Long setId(Long id){
        this.id=id;
    }
    public void getName(){
        return name;
    }
    public String setName(String name){
        this.name=name;
    }
    public void getType(){
        return type;
    }
    public  String setType(String type){
        this.type=type;
    }
    public Category(Long id,String name,String type){
        this.id=id;
        this.name=name;
        this.type=type;
    }
    public Category(){

    }
}