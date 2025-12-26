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

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionLogRepository repo;

    @Autowired
    private UserRepository userRepo;

    public TransactionLog addTransaction(Long userId, TransactionLog log) {
        User user = userRepo.findById(userId).orElseThrow();
        log.setUser(user);
        return repo.save(log);
    }

    public List<TransactionLog> getTransactions(Long userId) {
        return repo.findByUserId(userId);
    }
}

