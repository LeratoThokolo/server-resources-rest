/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "customer_order")
public class Order implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderID;
    private int orderNumber;
    private double amount;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreated;
    private String delivered;
    
    @Column(name = "user_id")
    private int userID;
    
    private String houseNo;
    
    private String fullNames;
    
    private String area;
   
    @Column(name = "driver_id")
    private int driverID;

    public Order() {
    }

    public Order(int orderID, int orderNumber, double amount, Date dateCreated, String delivered, int userID, String houseNo, String fullNames, String area, int driverID) {
        this.orderID = orderID;
        this.orderNumber = orderNumber;
        this.amount = amount;
        this.dateCreated = dateCreated;
        this.delivered = delivered;
        this.userID = userID;
        this.houseNo = houseNo;
        this.fullNames = fullNames;
        this.area = area;
        this.driverID = driverID;
    }

    public Order(String json) throws IOException {
        
        Order o = new ObjectMapper().readValue(json, Order.class);
        this.orderID = o.orderID;
        this.orderNumber = o.orderNumber;
        this.amount = o.amount;
        this.dateCreated = o.dateCreated;
        this.delivered = o.delivered;
        this.userID = o.userID;
        this.houseNo = o.houseNo;
        this.fullNames = o.fullNames;
        this.area = o.area;
        this.driverID = o.driverID;
        
    }
    
    
    
    public int getOrderNumber() {
        return orderNumber;
    }

    public String getDelivered() {
        return delivered;
    }

    public void setDelivered(String delivered) {
        this.delivered = delivered;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getFullNames() {
        return fullNames;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
