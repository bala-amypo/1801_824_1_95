// package com.example.demo.service;
 
// import com.example.demo.model.User;
 
// public interface UserService{
//     public User register(User user);

    
//      public User findByEmails(String email);
    
// }
package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User register(User user);

    User getByEmail(String email);   // 🔥 REQUIRED by tests & controller
}
