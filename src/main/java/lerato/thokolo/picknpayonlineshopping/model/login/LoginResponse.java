/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;
import lerato.thokolo.picknpayonlineshopping.model.user.User;

/**
 *
 * @author MANDELACOMP2
 */
public class LoginResponse implements Serializable{
    
    private User user;
    private String messageResponse;

    public LoginResponse() {
    }
    
    public LoginResponse(String json) throws IOException{
    
        LoginResponse lr = new ObjectMapper().readValue(json, LoginResponse.class);
        this.user = lr.user;
        this.messageResponse = lr.messageResponse;
    }

    public LoginResponse(User user, String messageResponse) {
        this.user = user;
        this.messageResponse = messageResponse;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }
}
