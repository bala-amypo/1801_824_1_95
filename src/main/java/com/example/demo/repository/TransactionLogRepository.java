// package com.example.demo.repository;
// import com.example.demo.model.User;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.TransactionLog;
// import java.util.List;
// public interface TransactionLogRepository extends JpaRepository<TransactionLog,Long>{
//       List<TransactionLog> findByUser(User user);
// }
package com.example.demo.repository;

import com.example.demo.model.TransactionLog;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionLogRepository
        extends JpaRepository<TransactionLog, Long> {

    // 🔥 REQUIRED BY TESTS
    List<TransactionLog> findByUser(User user);
}
