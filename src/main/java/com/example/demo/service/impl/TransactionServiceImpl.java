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
import com.example.demo.model.User;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransactionService;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository repo;
    private final UserRepository userRepo;

    // ✅ REQUIRED constructor
    public TransactionServiceImpl(TransactionLogRepository repo,
                                  UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    @Override
    public TransactionLog addTransaction(Long userId, TransactionLog log) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (log.getAmount() <= 0) {
            throw new RuntimeException("Amount must be positive");
        }

        if (log.getTransactionDate() != null &&
            log.getTransactionDate().isAfter(LocalDate.now())) {
            throw new RuntimeException("Date cannot be in future");
        }

        log.setUser(user);

        return repo.save(log);
    }

    @Override
    public List<TransactionLog> getTransactions(Long userId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return repo.findByUser(user);
    }
}

