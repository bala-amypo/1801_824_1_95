package com.example.demo.service;
import java.util.List; 
import com.example.demo.model.TransactionLog;
 
public interface TransactionService{
    public TransactionLog addTransaction(Long id,TransactionLog log);
    public List<TransactionLog> getUserTransactions(Long id);
}
