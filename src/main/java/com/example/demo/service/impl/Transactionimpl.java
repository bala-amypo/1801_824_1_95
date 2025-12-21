package com.example.demo.service;
import java.util.List; 
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.model.TransactionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class Transactionimpl implements TransactionService{
    @Autowired
    TransactionLogRepository tr;
    public TransactionLog addTransaction(Long userId,TransactionLog log){
         return tr.save(userId);
    }
    public List<TransactionLog> getUserTransaction(Long userId){
        return tr.findUserId(userId);
}
