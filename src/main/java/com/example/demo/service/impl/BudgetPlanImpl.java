// package com.example.demo.service.impl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.model.BudgetPlan;
// import com.example.demo.model.User;
// import com.example.demo.repository.BudgetPlanRepository;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.BudgetPlanService;

// @Service
// public class BudgetPlanimpl implements BudgetPlanService {

//     @Autowired
//     private BudgetPlanRepository budgetPlanRepository;

//     @Autowired
//     private UserRepository userRepository;

//     // CREATE BudgetPlan
//     @Override
//     public BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan) {

//         // 1️⃣ Fetch User
//         User user = userRepository.findById(userId)
//                 .orElseThrow(() -> new RuntimeException("User not found"));

//         // 2️⃣ Set User in BudgetPlan
//         plan.setUser(user);

//         // 3️⃣ Save BudgetPlan
//         return budgetPlanRepository.save(plan);
//     }

//     // GET BudgetPlan by user + month + year
//     @Override
//     public BudgetPlan getBudgetPlan(Long userId, Integer month, Integer year) {

//         return budgetPlanRepository
//                 .findByUserIdAndMonthAndYear(userId, month, year)
//                 .orElseThrow(() -> new RuntimeException("BudgetPlan not found"));
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.service.BudgetPlanService;
import org.springframework.stereotype.Service;

@Service
public class BudgetPlanImpl implements BudgetPlanService {

    private final BudgetPlanRepository repo;

    public BudgetPlanImpl(BudgetPlanRepository repo) {
        this.repo = repo;
    }

    public BudgetPlan create(User user, int month, int year, double income) {
        return repo.save(new BudgetPlan(user, month, year, income));
    }
}
