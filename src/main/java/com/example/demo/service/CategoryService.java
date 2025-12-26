// package com.example.demo.service;
//  import java.util.List;
// import com.example.demo.model.Category;
 
// public interface CategoryService {
//     public Category addCategory(Category cat);
//     public List<Category>getAllCategory();
// }

package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Category;

public interface CategoryService {
    Category addCategory(Category category);
    List<Category> getAll();
}
