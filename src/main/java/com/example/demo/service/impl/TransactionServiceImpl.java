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

import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.TransactionLog;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository logRepo;

    public TransactionServiceImpl(TransactionLogRepository logRepo) {
        this.logRepo = logRepo;
    }

    @Override
    public TransactionLog addTransaction(TransactionLog log) {

        // 🔥 REQUIRED BY TESTS
        log.validate();

        return logRepo.save(log);
    }
}

