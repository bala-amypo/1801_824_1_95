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

import org.springframework.stereotype.Service;
import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BudgetPlanService;

@Service
public class BudgetPlanImpl implements BudgetPlanService {

    private final BudgetPlanRepository budgetRepo;
    private final UserRepository userRepo;

    public BudgetPlanImpl(BudgetPlanRepository budgetRepo, UserRepository userRepo) {
        this.budgetRepo = budgetRepo;
        this.userRepo = userRepo;
    }

    @Override
    public BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan) {
        User user = userRepo.findById(userId).orElseThrow();
        plan.setUser(user);
        return budgetRepo.save(plan);
    }

    @Override
    public BudgetPlan getBudgetPlan(Long userId, Integer month, Integer year) {
        User user = userRepo.findById(userId).orElseThrow();
        return budgetRepo.findByUserAndMonthAndYear(user, month, year)
                .orElseThrow();
    }
}
