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
import com.example.demo.model.Category;
import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository logRepo;
    private final UserRepository userRepo;
    private final CategoryRepository categoryRepo;

    public TransactionServiceImpl(TransactionLogRepository logRepo,
                                  UserRepository userRepo,
                                  CategoryRepository categoryRepo) {
        this.logRepo = logRepo;
        this.userRepo = userRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public TransactionLog addTransaction(Long userId,
                                         Long categoryId,
                                         TransactionLog log) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));

        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new BadRequestException("Category not found"));

        // 🔥 THESE CALLS CAUSED YOUR ERROR
        log.setUser(user);
        log.setCategory(category);

        // 🔥 REQUIRED BY TESTS
        log.validate();

        return logRepo.save(log);
    }
}
