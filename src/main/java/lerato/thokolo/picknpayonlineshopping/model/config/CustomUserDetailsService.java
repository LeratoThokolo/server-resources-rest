/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.config;

import java.util.Optional;
import lerato.thokolo.picknpayonlineshopping.model.user.User;
import lerato.thokolo.picknpayonlineshopping.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;
    
    
    @Override
    public CustomUserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        
        Optional<User> optionalUser = userRepository.findByUserName(userName);
        
        optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!!"));
        
        return optionalUser.map(CustomUserDetails::new).get();
    }
}
