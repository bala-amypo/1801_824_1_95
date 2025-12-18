package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;


@Entity
public class Category{
    @Id
    @GeneratedValue(strategy=GeneratedType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String name;
    String type;

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
    public setType(String type)
}