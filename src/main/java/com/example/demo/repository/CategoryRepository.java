
// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.Category;

// public interface CategoryRepository extends JpaRepository<Category,Long>{
      
// }
package com.example.demo.repository;

import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // 🔥 REQUIRED BY TEST
    boolean existsByName(String name);
}


