/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.bankdetail;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lerato.thokolo.picknpayonlineshopping.model.bank.Bank;

/**
 *
 * @author User
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BankDetail implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int bankDetailID;
    
    @OneToOne
    @JoinColumn(name = "bank_id")
    @JsonBackReference
    private Bank bank;
    
    private int pin;
    private int accountNumber;
    
    @Column(name = "user_id")
    private int userID;

    public BankDetail() {
    }

    public BankDetail(int bankDetailID, Bank bank, int pin, int accountNumber, int userID) {
        this.bankDetailID = bankDetailID;
        this.bank = bank;
        this.pin = pin;
        this.accountNumber = accountNumber;
        this.userID = userID;
    }
    
    public BankDetail(String json) throws IOException{
    
        BankDetail bankDetail = new ObjectMapper().readValue(json, BankDetail.class);
        this.bankDetailID = bankDetail.bankDetailID;
        this.bank = bankDetail.bank;
        this.pin = bankDetail.pin;
        this.accountNumber = bankDetail.accountNumber;
        this.userID = bankDetail.userID;
    }

    public int getBankDetailID() {
        return bankDetailID;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public void setBankDetailID(int bankDetailID) {
        this.bankDetailID = bankDetailID;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
}
