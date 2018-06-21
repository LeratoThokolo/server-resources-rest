/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lerato.thokolo.picknpayonlineshopping.model.login.Login;
import lerato.thokolo.picknpayonlineshopping.model.login.LoginResponse;
import lerato.thokolo.picknpayonlineshopping.model.role.Role;
import lerato.thokolo.picknpayonlineshopping.model.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    public void saveUser(User user){
    
        Role role = roleRepository.getOne(1);
        String roleName = role.getName();
        role.setName(roleName);
        
        //Add admin role to set
        Set<Role> roles = new HashSet<Role>(){{
            add(role);
        }};
        
        //Set user role to role object
        user.setRoles(roles);
        userRepository.save(user);
    }
    
    public List<User> getAllUsers(){
    
        return userRepository.findAll();
    }
    
    public User getUser(int id){
    
        return userRepository.getOne(id);
    }
    
    public User updateUser(User user){
    
        User u = userRepository.getOne(user.getUserID());
        
        if( u == null){
            
            return null;
        }
        
        return userRepository.save(user);
    }
    
    public void deleteUser(int id){
        
        userRepository.deleteById(id);
    }
    
    public User getByUserName(String userName){
        
        User user  = null;
        for (int i = 0; i < this.getAllUsers().size(); i++) {
            
            user = this.getAllUsers().get(i);
           
            if(this.getAllUsers().get(i).getUserName().equals(userName)){
            
                user = this.getAllUsers().get(i);
                break;
            }
        }
        
        return user;
    }
    
    public User getByUserEmail(String email){
        
        User user  = null;
        for (int i = 0; i < this.getAllUsers().size(); i++) {
            
            user = this.getAllUsers().get(i);
           
            if(this.getAllUsers().get(i).getUserName().equals(email)){
            
                user = this.getAllUsers().get(i);
                break;
            }
        }
        
        return user;
    }
    
    public LoginResponse login(Login login) {

       LoginResponse loginResponse = new LoginResponse(new User(), "Incorrect username or password");

        for (int i = 0; i < this.getAllUsers().size(); i++) {

           if(login.getUserName().equals(this.getAllUsers().get(i).getUserName())
                   && login.getPassword().equals(this.getAllUsers().get(i).getPassword())){
           
               loginResponse.setUser(this.getAllUsers().get(i));
               loginResponse.setMessageResponse("Successfully logged in");
           }

        }

        return loginResponse;
    }
    
    public LoginResponse recoverPassword(String email) {

       LoginResponse loginResponse = new LoginResponse(new User(), "Your account was not found");

        for (int i = 0; i < this.getAllUsers().size(); i++) {

           if(email.equals(this.getAllUsers().get(i).getEmail())){
           
               loginResponse.setUser(this.getAllUsers().get(i));
               loginResponse.setMessageResponse("Password recovery successful");
           }

        }

        return loginResponse;
    }
    
    public User deleteAppUser(int userID){
    
      
        User u = this.getUser(userID);
        
        if(u == null){
        
            return null;
        }else{
        
            this.userRepository.deleteById(userID);
            
            return u;
        }
       
        
        
    }
}
