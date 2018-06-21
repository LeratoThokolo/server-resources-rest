/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.user;

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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import lerato.thokolo.picknpayonlineshopping.model.role.Role;

/**
 *
 * @author User
 */

@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class User implements Serializable{
    
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

    public User() {
    }
    
    public User(String json) throws IOException{
    
        User u = new ObjectMapper().readValue(json, User.class);
        this.cellNo = u.cellNo;
        this.email = u.email;
        this.fullNames = u.fullNames;
        this.password = u.password;
        this.roles = u.roles;
        this.userID = u.userID;
        this.userName = u.userName;
        this.lastPasswordResetDate = u.lastPasswordResetDate;
    }

    public User(int userID, String fullNames, String userName, String email, String cellNo, String password, Date lastPasswordResetDate, Set<Role> roles) {
        this.userID = userID;
        this.fullNames = fullNames;
        this.userName = userName;
        this.email = email;
        this.cellNo = cellNo;
        this.password = password;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.roles = roles;
    }
    
    
    
    public User(User user){
        
        this.cellNo = user.getCellNo();
        this.email = user.getEmail();
        this.fullNames = user.getFullNames();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.userID = user.getUserID();
        this.userName = user.getUserName();
        this.lastPasswordResetDate = user.lastPasswordResetDate;
       
    }
 
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullNames() {
        return fullNames;
    }

    public void setFullNames(String fullNames) {
        this.fullNames = fullNames;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }
}
