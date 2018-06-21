/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.category;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public void saveCategory(Category category){
    
        categoryRepository.save(category);
    }
    
    public List<Category> getAllCategories(){
        
        return categoryRepository.findAll();
    }
    
    public Category updateCategory(Category category){
    
        Category c = categoryRepository.getOne(category.getCategoryID());
        
        if( c == null){
            
            return null;
        }
        
        return categoryRepository.save(category);
    }
    
    public Category getCategory(int id){
        
        
        return categoryRepository.getOne(id);
    }
    
    public void deleteCategory(int id){
        
        categoryRepository.deleteById(id);
    } 
    
}
