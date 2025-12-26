// package com.example.demo.service.impl;

// import java.time.LocalDateTime;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.model.BudgetPlan;
// import com.example.demo.model.BudgetSummary;
// import com.example.demo.repository.BudgetPlanRepository;
// import com.example.demo.repository.BudgetSummaryRepository;
// import com.example.demo.service.BudgetSummaryService;

// @Service
// public class BudgetSummaryimpl implements BudgetSummaryService {

//     @Autowired
//     private BudgetSummaryRepository budgetSummaryRepository;

//     @Autowired
//     private BudgetPlanRepository budgetPlanRepository;

//     // POST /generate/{budgetPlanId}
//     @Override
//     public BudgetSummary generateSummary(Long budgetPlanId) {

//         // 1️⃣ Get BudgetPlan
//         BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId)
//                 .orElseThrow(() -> new RuntimeException("BudgetPlan not found"));

//         // 2️⃣ Create BudgetSummary
//         BudgetSummary summary = new BudgetSummary();
//         summary.setBudgetPlan(plan);
//         summary.setTotal(0.0);           // later calculate
//         summary.setExpense(0.0);         // later calculate
//         summary.setStatus("UNDER_LIMIT");
//         summary.setGenerate(LocalDateTime.now());

//         // 3️⃣ Save & return
//         return budgetSummaryRepository.save(summary);
//     }

//     // GET /{budgetPlanId}
//     @Override
//     public BudgetSummary getSummary(Long budgetPlanId) {

//         return budgetSummaryRepository.findAll()
//                 .stream()
//                 .filter(s -> s.getBudgetPlan().getId().equals(budgetPlanId))
//                 .findFirst()
//                 .orElseThrow(() -> new RuntimeException("Summary not found"));
//     }
// }


















// // package com.example.demo.service;

// // import java.util.List;
// // import com.example.demo.model.BudgetPlan;
// // import com.example.demo.model.BudgetSummary;
// //  import com.example.demo.repository.BudgetSummaryRepository;
// //  import org.springframework.beans.factory.annotation.Autowired;
// //  import com.example.demo.service.BudgetSummaryService;
// //  import org.springframework.stereotype.Service;
 
// // import com.example.demo.model.BudgetSummary;
// //  @Service
// // public class BudgetSummaryimpl implements BudgetSummaryService {
// //    @Autowired
// //     BudgetSummaryRepository br;
// //     public BudgetSummary generateSummary(Long budgetPlanId){
// //          return br.save(budgetPlanId); 
// //     }
// //     public BudgetSummary getSummary(Long budgetPlanId){
// //           return br.findById(budgetPlanId);
// // }
// // }