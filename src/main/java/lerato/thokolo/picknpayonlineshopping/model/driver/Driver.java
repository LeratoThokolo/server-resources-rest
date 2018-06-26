/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.driver;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import lerato.thokolo.picknpayonlineshopping.model.role.Role;
import lerato.thokolo.picknpayonlineshopping.model.user.User;

/**
 *
 * @author User
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Driver extends User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    private String fullNames;

    @Column(unique = true)
    private String userName;

    @Column(unique = true)
    private String email;
    private String cellNo;
    private String password;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastPasswordResetDate;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userID"))
    private Set<Role> roles;

    public Driver() {
    }

    
    public Driver(int userID, String fullNames, String userName, String email, String cellNo, Date lastPasswordResetDate, Set<Role> roles) {
        this.userID = userID;
        this.fullNames = fullNames;
        this.userName = userName;
        this.email = email;
        this.cellNo = cellNo;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.roles = roles;
    }

    public Driver(String json) throws IOException {

        Driver d = new ObjectMapper().readValue(json, Driver.class);
        this.userID = d.userID;
        this.fullNames = d.fullNames;
        this.userName = d.userName;
        this.email = d.email;
        this.cellNo = d.cellNo;
        this.lastPasswordResetDate = d.lastPasswordResetDate;
        this.roles = d.roles;
    }

    @Override
    public int getUserID() {
        return userID;
    }

    @Override
    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String getFullNames() {
        return fullNames;
    }

    @Override
    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getCellNo() {
        return cellNo;
    }

    @Override
    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    @Override
    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @Override
    public Set<Role> getRoles() {
        return roles;
    }

    @Override
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
