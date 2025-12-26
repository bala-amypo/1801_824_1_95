package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionLogController {

    private final TransactionService service;

    public TransactionLogController(TransactionService service) {
        this.service = service;
    }

    // ✅ ADD TRANSACTION (FIXED)
    @PostMapping("/{userId}")
    public TransactionLog addTransaction(
            @PathVariable Long userId,
            @RequestBody TransactionLog log) {

        return service.addTransaction(userId, log);
    }

    // ✅ GET USER TRANSACTIONS
    @GetMapping("/{userId}")
    public List<TransactionLog> getUserTransactions(
            @PathVariable Long userId) {

        return service.getUserTransactions(userId);
    }
}
