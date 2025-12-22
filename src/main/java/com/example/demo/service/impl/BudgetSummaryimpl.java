package com.example.demo.service;

 import java.util.List;
import com.example.demo.model.BudgetSummary;
 import com.example.demo.repository.BudgetSummaryRepository;
 import org.springframework.beans.factory.annotation.Autowired;
 import com.example.demo.service.BudgetSummaryService;
 import org.springframework.stereotype.Service;
 
import com.example.demo.model.BudgetSummary;
 @Service
public class BudgetSummarimpl implements BudgetSummaryService {
   @Autowired
    BudgetSummaryRepository br;
    public BudgetSummary generateSummary(Long budgetPlanId){
         return br. 
    }
    public BudgetSummary getSummary(Long budgetPlanId){

}
}