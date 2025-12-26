
// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.Category;

// public interface CategoryRepository extends JpaRepository<Category,Long>{
      
// }
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // used to check duplicate category
    boolean existsByName(String name);
}
