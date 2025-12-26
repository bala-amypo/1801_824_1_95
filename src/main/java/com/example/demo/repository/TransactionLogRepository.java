// package com.example.demo.repository;
// import com.example.demo.model.User;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.TransactionLog;
// import java.util.List;
// public interface TransactionLogRepository extends JpaRepository<TransactionLog,Long>{
//       List<TransactionLog> findByUser(User user);
// }
package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;

public interface TransactionLogRepository
        extends JpaRepository<TransactionLog, Long> {

    // required by TransactionServiceImpl
    List<TransactionLog> findByUser(User user);

    // required by BudgetSummaryServiceImpl
    List<TransactionLog> findByUserAndTransactionDateBetween(
            User user,
            LocalDate startDate,
            LocalDate endDate
    );
}
