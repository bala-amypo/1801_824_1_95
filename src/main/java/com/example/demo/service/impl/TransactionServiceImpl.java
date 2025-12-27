package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository logRepo;
    private final UserRepository userRepo;

    public TransactionServiceImpl(TransactionLogRepository logRepo,
                                  UserRepository userRepo) {
        this.logRepo = logRepo;
        this.userRepo = userRepo;
    }

    @Override
    public TransactionLog addTransaction(Long userId, TransactionLog log) {

        User user = userRepo.findById(userId)
                .orElseThrow(() ->
                        new BadRequestException("User not found"));

        log.setUser(user);
        log.validate();

        return logRepo.save(log);
    }

    @Override
    public List<TransactionLog> getUserTransactions(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() ->
                        new BadRequestException("User not found"));

        return logRepo.findByUser(user);
    }
}
