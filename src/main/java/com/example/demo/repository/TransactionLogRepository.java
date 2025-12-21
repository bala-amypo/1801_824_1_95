package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.TransactionLog;

public interface TransactionLogRepository extends JpaRepository<TransactionLog,Long>{
      List<TransactionLog> findByUserId(Long userId);
}