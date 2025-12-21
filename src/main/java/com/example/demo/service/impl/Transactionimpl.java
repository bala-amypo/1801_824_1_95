package com.example.demo.service;
import java.util.List; 
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.model.TransactionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
public class Transactionimpl implements TransactionService{
    public TransactionLog addTransaction(Long userId,TransactionLog log);
    public List<TransactionLog> getUserTransactions(Long userId);
}
