/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.config;

import lerato.thokolo.picknpayonlineshopping.model.user.User;

/**
 *
 * @author User
 */
public final class JwtUserFactory  {

    public JwtUserFactory(CustomUserDetails c) {
        
    }

    public static CustomUserDetails createUser(User user){
        
        return new CustomUserDetails(user);

    }

}
