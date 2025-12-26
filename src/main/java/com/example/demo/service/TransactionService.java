// package com.example.demo.service;
// import java.util.List; 
// import com.example.demo.model.User;
// import com.example.demo.model.TransactionLog;
 
// public interface TransactionService{
//     public TransactionLog addTransaction(User user,TransactionLog log);
//     public List<TransactionLog> getUserTransactions(User user);
// }

package com.example.demo.service;

import com.example.demo.model.TransactionLog;
import java.util.List;

public interface TransactionService {
    TransactionLog add(TransactionLog log);
    List<TransactionLog> getUserTransactions(Long userId);
}
