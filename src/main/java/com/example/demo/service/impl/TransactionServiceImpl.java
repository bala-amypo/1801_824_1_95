// package com.example.demo.service;
// import java.util.List;
// import com.example.demo.model.User; 
// import com.example.demo.repository.TransactionLogRepository;
// import com.example.demo.model.TransactionLog;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// @Service
// public class Transactionimpl implements TransactionService{
//     @Autowired
//     TransactionLogRepository tr;
//     public TransactionLog addTransaction(User user,TransactionLog log){
//          log.setUser(user);
//        return tr.save(log);
     
    
//     }
//     public List<TransactionLog> getUserTransactions(User user){
//         return tr.findByUser(user);
// }
// }
package com.example.demo.service.impl;

import com.example.demo.model.TransactionLog;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository repo;

    public TransactionServiceImpl(TransactionLogRepository repo) {
        this.repo = repo;
    }

    @Override
    public TransactionLog addTransaction(Long userId, TransactionLog log) {
        return repo.save(log);
    }

    @Override
    public List<TransactionLog> getTransactions(Long userId) {
        return repo.findByUserId(userId);
    }
}
