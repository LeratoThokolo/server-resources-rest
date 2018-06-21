/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.product;

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
@RequestMapping("/product")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/all-products", method = RequestMethod.GET)
    public List<Product> getAll() {

        return productService.getAllProducts();
    }

    @RequestMapping(value = "/all-products-by-category/{categoryID}", method = RequestMethod.GET)
    public List<Product> getAllByCategory(@PathVariable int categoryID) {

        return productService.getByCategory(categoryID);
    }
    
    @RequestMapping(value = "/all-products-by-supplier-id/{supplierID}", method = RequestMethod.GET)
    public List<Product> getAllBySupplierID(@PathVariable int supplierID) {

        return productService.getBySupplierID(supplierID);
    }


    @RequestMapping(value = "/save-product", method = RequestMethod.POST)
    public String saveProduct(@RequestBody Product product) {

        productService.saveProduct(product);

        return "Product saved successfully";
    }
    
    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product) {

        return this.productService.addProduct(product);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value = "/update-product", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product) {

        return productService.updateProduct(product);

    }

    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable int id) {

        productService.deleteProduct(id);

        return "Product deleted successfully";
    }
    
    @RequestMapping(value = "/delete-Product/{id}", method = RequestMethod.DELETE)
    public Product deleteProductByID(@PathVariable int id) {

        return productService.deleteProductByID(id);
    }

    @RequestMapping(value = "/product-details/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable int id) {

        return productService.getProduct(id);
    }

    /*
    @RequestMapping(value = "/user-products-ordered", method = RequestMethod.GET)
    public List<Product> getByUserOrderUsername(@PathVariable String username) {

        return productService.byUserOrder(username);
    }
*/
}
