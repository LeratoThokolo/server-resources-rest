/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.config;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import lerato.thokolo.picknpayonlineshopping.model.role.Role;
import lerato.thokolo.picknpayonlineshopping.model.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author User
 */
public class CustomUserDetails extends User implements UserDetails{

    public CustomUserDetails() {
    }

    public CustomUserDetails(User user) {
        
        super(user);

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
       return getRoles().
                stream()
                .map(role -> new SimpleGrantedAuthority
                ("ROLE_" + role.getName()) )
                .collect(Collectors.toList());
    }

    @Override
    public void setRoles(Set<Role> roles) {
        super.setRoles(roles); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUserName(String userName) {
        super.setUserName(userName); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFullNames(String fullNames) {
        super.setFullNames(fullNames); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUserID(int userID) {
        super.setUserID(userID); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword() {
      
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    } 

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getFullNames() {
        return super.getFullNames();
    }

    @Override
    public int getUserID() {
        return super.getUserID();
    }
    
    
}
