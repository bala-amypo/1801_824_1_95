// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.User;
// import java.util.Optional;
// public interface UserRepository extends JpaRepository<User,Long>{
//        Optional<User> findByEmail(String email);
// }
package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // required by UserService
    Optional<User> findByEmail(String email);

    // used to avoid duplicate registration
    boolean existsByEmail(String email);
}
