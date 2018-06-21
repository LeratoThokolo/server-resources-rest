/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.customer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;
import javax.persistence.Entity;
import lerato.thokolo.picknpayonlineshopping.model.user.User;

/**
 *
 * @author User
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer extends User implements Serializable{
    
    private String houseNo;
    private String streetName;
    private String surburb;
    private String town;
    private String postalCode;

    public Customer() {
    }

    public Customer(Customer c) {
    }
    
    public Customer(String json) throws IOException{
    
        Customer c = new ObjectMapper().readValue(json, Customer.class);
        
        this.houseNo = c.houseNo;
        this.streetName = c.streetName;
        this.surburb = c.surburb;
        this.town = c.town;
        this.postalCode = c.postalCode;
        
    }
    
  
    public Customer(String houseNo, String streetName, String surburb, String town, String postalCode, User user) {
        super(user);
        this.houseNo = houseNo;
        this.streetName = streetName;
        this.surburb = surburb;
        this.town = town;
        this.postalCode = postalCode;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getSurburb() {
        return surburb;
    }

    public void setSurburb(String surburb) {
        this.surburb = surburb;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
