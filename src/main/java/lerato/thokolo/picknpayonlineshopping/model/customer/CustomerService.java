/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.customer;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lerato.thokolo.picknpayonlineshopping.model.role.Role;
import lerato.thokolo.picknpayonlineshopping.model.role.RoleRepository;
import lerato.thokolo.picknpayonlineshopping.model.user.User;
import lerato.thokolo.picknpayonlineshopping.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void saveCustomer(Customer customer) {

        Role role = roleRepository.getOne(4);
        String roleName = role.getName();
        role.setName(roleName);

        //Add customer role to set
        Set<Role> roles = new HashSet<Role>() {
            {

                add(role);
            }
        };

        //Set customer role to customer object
        customer.setRoles(roles);

        customerRepository.save(customer);
    }
    
    public List<User> allUsers(){
    
        return userRepository.findAll();
        
    }

    public RegisterCustomerResponse saveCustomerResponse(Customer customer) {

        RegisterCustomerResponse registerCustomerResponse = new RegisterCustomerResponse(customer, "Successfully registered with us!!");
        for (int i = 0; i < this.allUsers().size(); i++) {
            
            String email = this.allUsers().get(i).getEmail();
             String userName = this.allUsers().get(i).getUserName();
            if(customer.getEmail().equals(email)){
            
               
               return new RegisterCustomerResponse(new Customer(),"Email already taken!!");
                
            }
            else if(customer.getUserName().equals(userName)){
            
                return new RegisterCustomerResponse(new Customer(), "User name already taken!!");
               
            }
              
        }
        
        Role role = roleRepository.getOne(4);
                String roleName = role.getName();
                role.setName(roleName);

                //Add customer role to set
                Set<Role> roles = new HashSet<Role>() {
                    {

                        add(role);
                    }
                };

                //Set customer role to customer object
                customer.setRoles(roles);

                customerRepository.save(customer);
        
        
       
        return registerCustomerResponse;
    }

    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    public Customer getCustomer(int id) {

        return customerRepository.getOne(id);
    }

    public void deleteCustomer(int id) {

        customerRepository.deleteById(id);
    }
    
    public Customer deleteCustomerByID(int customerID){
    
        Customer c = this.getCustomer(customerID);
        
        if(c == null){
        
            return null;
        }
        else{
        
            this.customerRepository.deleteById(customerID);
            
            return c;
        }
        
    }

    public Customer updateCustomer(Customer customer) {

        Customer c = customerRepository.getOne(customer.getUserID());

        if (c == null) {

            return null;
        }

         Role role = roleRepository.getOne(4);
                String roleName = role.getName();
                role.setName(roleName);

                //Add customer role to set
                Set<Role> roles = new HashSet<Role>() {
                    {

                        add(role);
                    }
                };

                //Set customer role to customer object
                customer.setRoles(roles);
        
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerByUsername(String username) {

        return customerRepository.findByUserName(username);
    }
    
}
