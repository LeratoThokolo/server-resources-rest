/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author MANDELACOMP2
 */
public class RegisterCustomerResponse implements Serializable{
    
    private Customer customer;
    private String responseMessage;

    public RegisterCustomerResponse() {
    }

    public RegisterCustomerResponse(String json) throws IOException {
         
        RegisterCustomerResponse rcr = new ObjectMapper().readValue(json, RegisterCustomerResponse.class);
        this.customer = rcr.customer;
        this.responseMessage = rcr.responseMessage;
        
    }

    
    
    public RegisterCustomerResponse(Customer customer, String responseMessage) {
        this.customer = customer;
        this.responseMessage = responseMessage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
      
}
