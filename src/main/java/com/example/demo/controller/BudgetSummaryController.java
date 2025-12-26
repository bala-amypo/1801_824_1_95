//  package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.example.demo.model.BudgetSummary;
// import com.example.demo.service.BudgetSummaryService;

// @RestController
// @RequestMapping("/summary")
// public class BudgetSummaryController {

//     @Autowired
//     private BudgetSummaryService budgetSummaryService;

//     // POST /summary/generate/{budgetPlanId}
//     @PostMapping("/generate/{budgetPlanId}")
//     public BudgetSummary generateSummary(@PathVariable Long budgetPlanId) {
//         return budgetSummaryService.generateSummary(budgetPlanId);
//     }

//     // GET /summary/{budgetPlanId}
//     @GetMapping("/{budgetPlanId}")
//     public BudgetSummary getSummary(@PathVariable Long budgetPlanId) {
//         return budgetSummaryService.getSummary(budgetPlanId);
//     }
// }
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.BudgetSummary;
import com.example.demo.service.BudgetSummaryService;

@RestController
@RequestMapping("/summary")
public class BudgetSummaryController {

    private final BudgetSummaryService service;

    public BudgetSummaryController(BudgetSummaryService service) {
        this.service = service;
    }

    @PostMapping("/generate/{planId}")
    public BudgetSummary generate(@PathVariable Long planId) {
        return service.generateSummary(planId);
    }

    @GetMapping("/{planId}")
    public BudgetSummary get(@PathVariable Long planId) {
        return service.getSummary(planId);
    }
}
