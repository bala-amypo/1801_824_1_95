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

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionLogController {

    @Autowired
    private TransactionService service;

    @PostMapping("/{user}")
    public TransactionLog add(@PathVariable Long user,
                              @RequestBody TransactionLog log) {
        return service.addTransaction(user, log);
    }

    @GetMapping("/{user}")
    public List<TransactionLog> get(@PathVariable Long user) {
        return service.getTransactions(user);
    }
}
