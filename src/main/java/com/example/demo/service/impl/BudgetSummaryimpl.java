package com.example.demo.service;

 import java.util.List;
import com.example.demo.model.BudgetSummary;
 import com.example.demo.repository.BudgetSummaryRepository;
 import org.springframework.beans.factory.annotation.Autowired;
 import com.example.demo.service.BudgetSummaryService;
 import org.springframework.stereotype.Service;
 
import com.example.demo.model.BudgetSummary;
 @Service
public class BudgetSummaryimpl implements BudgetSummaryService {
   @Autowired
    BudgetSummaryRepository br;
    public BudgetSummary generateSummary(BudgetPlan budgetPlanId){
         return br.save(budgetPlanId); 
    }
    public BudgetSummary getSummary(BudgetPlan budgetPlanId){
          return br.findById(budgetPlanId);
}
}