/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.product;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class ProductService  {
    
    @Autowired
    private ProductRepository productRepository;
    
    public void saveProduct(Product product){
    
        product.setPurchased(false);
        productRepository.save(product);
    }
    
    public Product addProduct(Product product){
    
        product.setPurchased(false);
        productRepository.save(product);
        
        return product;
    }
    
    
    
    public Product getProduct(int id){
        
        return productRepository.getOne(id);
    }
    
    public List<Product> getAllProducts(){
    
        return productRepository.findAll();
    }
    
    public Product updateProduct(Product product){
        
        Product p = productRepository.getOne(product.getProductID());
        
        if( p == null){
        
            return null;
        }
        
        return productRepository.save(product);
    }
    
    public void deleteProduct(int id){
    
        productRepository.deleteById(id);
    }
    
    public Product deleteProductByID(int id){
    
        Product p = this.productRepository.getOne(id);
        
        if(p == null){
        
            return null;
        }else{
        
            this.productRepository.deleteById(id);
        }
        
        return p;
    }
    
    public ArrayList<Product> getByCategory(int categoryID){
    
        List<Product> products = getAllProducts();
        
        ArrayList<Product> pts = new ArrayList<>();
        
        if(!products.isEmpty()){
        
            products.stream().filter((product) -> (product.getCategory().getCategoryID() == categoryID)).forEachOrdered((product) -> {
                pts.add(product);
            });
        }
        
       return pts;
    }
    
     public ArrayList<Product> getBySupplierID(int supplierID){
    
        List<Product> products = getAllProducts();
        
        ArrayList<Product> pts = new ArrayList<>();
        
        if(!products.isEmpty()){
            for (int i = 0; i < products.size(); i++) {
                
                if( products.get(i).getSupplier().getUserID() == supplierID){
                
                    pts.add(products.get(i));
                }
            }
        } else {
        }
        
       return pts;
    }
    
    /*
    public ArrayList<Product> byUserOrder(String userName){
    
        List<Product> products = getAllProducts();
        
        ArrayList<Product> pts = new ArrayList<>();
        
        if(!products.isEmpty()){
        
            products.stream().filter((Product product) -> product.getOrder().getUser().getUserName().equals(userName)).forEachOrdered((product) -> {
                pts.add(product);
            });
        }
        
       return pts;
    }
*/
 
}
