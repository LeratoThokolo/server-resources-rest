/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.config;

import org.springframework.security.core.AuthenticationException;

/**
 *
 * @author User
 */
public class JwtTokenMissingException extends AuthenticationException{
    
    public JwtTokenMissingException(String msg) {
        super(msg);
    }
    
}
