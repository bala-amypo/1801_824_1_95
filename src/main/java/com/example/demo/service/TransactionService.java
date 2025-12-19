package com.example.demo.service;
 
import com.example.demo.model.TransactionLog;
 
public interface TransactionService{
    public TransactionLog addTransaction(Long userId,TransactionLog log);
    public List<TransactionLog> getUserTransactions(Long userId);
}
