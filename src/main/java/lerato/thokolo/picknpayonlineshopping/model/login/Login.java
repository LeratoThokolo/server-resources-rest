/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;

/**
 * Lerato Thokolo
 *
 */
public class Login implements Serializable{
    
    private String userName;
    private String password;

    public Login() {
        
    }
    
    
    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    
    public Login(String json) throws IOException {
    
        Login login = new ObjectMapper().readValue(json, Login.class);
        this.userName = login.userName;
        this.password = login.password;
        
    }
        
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
