package com.example.demo.service;
import java.util.List; 
import com.example.demo.model.User;
import com.example.demo.model.TransactionLog;
 
public interface TransactionService{
    public TransactionLog addTransaction(User user,TransactionLog log);
    public List<TransactionLog> getUserTransactions(User user);
}
