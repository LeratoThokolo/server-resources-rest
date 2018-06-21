/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.customer;

import java.util.List;
import java.util.Optional;
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
@RequestMapping("/customer")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*" )
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    
    @RequestMapping(value = "/admin/all-customers", method = RequestMethod.GET)
    public List<Customer> getCustomers(){
        
        return customerService.getAllCustomers();
    }
    
    @RequestMapping(value = "/picknpay/c-register", method = RequestMethod.POST)
    public String saveCustomer(@RequestBody Customer customer){
    
        for (int i = 0; i < getCustomers().size(); i++) {
            
            if( getCustomers().get(i).getEmail().equals(customer.getEmail())){
            
                return "Customer with the same user email already exists!!";
            }
            else if(getCustomers().get(i).getUserName().equals(customer.getUserName())){
            
                return "Username already taken!!";
            }
        }
        
        customerService.saveCustomer(customer);
        
        return "Customer saved successfully!!";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RegisterCustomerResponse register(@RequestBody Customer customer){
    
        return customerService.saveCustomerResponse(customer);
    }
    
    @RequestMapping(value = "/customer-details/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable int id){
        
        return customerService.getCustomer(id);
    }
    
    
    @RequestMapping(value = "/customer-remove/{id}", method = RequestMethod.DELETE)
    public String deleteCustomer(@PathVariable int id){
        
        customerService.deleteCustomer(id);
        
        return "Customer deleted successfully!!";
    }
    
    @RequestMapping(value = "/customer-delete/{id}", method = RequestMethod.DELETE)
    public Customer deleteCustomerByID(@PathVariable int id){
        
        return this.customerService.deleteCustomerByID(id);
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*" )
    @RequestMapping(value = "/customer-update", method = RequestMethod.PUT)
    public Customer updateCustomer(@RequestBody Customer customer){
        
        return customerService.updateCustomer(customer);
    }
    
    @RequestMapping(value = "/find-by-username/{userName}", method = RequestMethod.GET)
    public Optional<Customer> findByUserName(@PathVariable String userName){
    
        return customerService.getCustomerByUsername(userName);
    }
    
}
