package com.example.demo.service;
import java.util.List; 
import com.example.demo.model.TransactionLog;
 
public interface TransactionService{
    public TransactionLog addTransaction(String user,TransactionLog log);
    public TransactionLog getUserTransactions(String user);
}
