package com.example.demo.service;
import jakarta.persistence.Service;
import com.example.demo.model.TransactionLog;
@Service
public interface TransactionService{
    public TransactionLog addTransaction(Long userId,TransactionLog log);
    public List<TransactionLog> getUserTransactions(Long userId);
}
