/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.category;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*", allowedHeaders = "*" )
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    @RequestMapping(value = "/all-categories", method = RequestMethod.GET)
    public List<Category> getAll(){
        
        return categoryService.getAllCategories();
    }
    
    @RequestMapping(value = "/save-category", method = RequestMethod.POST)
    public String saveCategory(@RequestBody Category category){
        
        categoryService.saveCategory(category);
        
        return "Category added successfully!!";
    }
    
    @RequestMapping(value = "/add-category", method = RequestMethod.POST)
    public Category addCategory(@RequestBody Category category){
        
        return this.categoryService.addCategory(category);
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*" )
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteCategory(@PathVariable int id){
        
        categoryService.deleteCategory(id);
        
        return "Category deleted successfully!!";
    }
    

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Category updateCategory(@RequestBody Category customer){
        
        return categoryService.updateCategory(customer);
    }
    
    @RequestMapping(value = "/category-details/{id}", method = RequestMethod.GET)
    public Category getCategory(@PathVariable int id){
        
        return categoryService.getCategory(id);
    }
    
    @RequestMapping(value = "/delete-category/{id}", method = RequestMethod.DELETE)
    public Category deleteCategoryByID(@PathVariable int id){
        
        return this.categoryService.deleteCategoryByID(id);
    }
    
}
