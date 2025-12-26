// package com.example.demo.controller;
// import java.util.List;
// import com.example.demo.model.User;
// import com.example.demo.service.TransactionService;
// import com.example.demo.model.TransactionLog;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.beans.factory.annotation.Autowired;

// @RestController
// @RequestMapping("/transactions")
// public class TransactionLogController {

//     @Autowired
//     TransactionService ts;

     
//     @PostMapping("/{user}")
//     public TransactionLog addTransaction(
//             @PathVariable User user,
//             @RequestBody TransactionLog log) {

//         return ts.addTransaction(user, log);
//     }

    
//     @GetMapping("/{user}")
//     public List<TransactionLog> getAll(@PathVariable User user) {
//         return ts.getUserTransactions(user);
//     }
// }
package com.example.demo.controller;

import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionLogController {

    private final TransactionService service;

    public TransactionLogController(TransactionService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    public TransactionLog addTransaction(
            @PathVariable Long userId,
            @RequestBody TransactionLog log
    ) {
        return service.addTransaction(userId, log);
    }

    @GetMapping("/user/{userId}")
    public List<TransactionLog> getUserTransactions(@PathVariable Long userId) {
        return service.getUserTransactions(userId);
    }
}

