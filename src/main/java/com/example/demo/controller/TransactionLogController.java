package com.example.demo.controller;
import java.util.List;
import com.example.demo.service.TransactionService;
import com.example.demo.model.TransactionLog;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class TransactionLogController  {
    @Autowired
    TransactionService ts;
    @PostMapping("/{userId}")
    public TransactioLog addtrans(@RequestBody TransactionLog userId){
        return 
    }
    
    @GetMapping("/{userId}")
    public List<TransactionLog getall(@PathVariable TransactionLog userId) {

    }
    
    
}