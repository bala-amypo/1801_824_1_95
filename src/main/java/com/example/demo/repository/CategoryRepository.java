
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Category;

public interface Repository extends JpaRepository<User,Long>{
      
}