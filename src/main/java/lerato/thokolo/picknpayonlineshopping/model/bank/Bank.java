/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.bank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lerato.thokolo.picknpayonlineshopping.model.bankdetail.BankDetail;

/**
 *
 * @author User
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bank implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bankID;
    private String bankName;
    private String branchCode;
    
    @OneToOne(mappedBy = "bank", cascade = CascadeType.ALL)
    @JsonManagedReference
    private BankDetail bankDetail;
   
    public Bank() {
    }

    public Bank(int bankID, String bankName, String branchCode, BankDetail bankDetail) {
        this.bankID = bankID;
        this.bankName = bankName;
        this.branchCode = branchCode;
        this.bankDetail = bankDetail;
    }
    
    public Bank(String json) throws IOException{
        
        Bank bank = new ObjectMapper().readValue(json, Bank.class);
        this.bankID = bank.bankID;
        this.bankName = bank.bankName;
        this.branchCode = bank.branchCode;
        this.bankDetail = bank.bankDetail;
    
    }

    public BankDetail getBankDetail() {
        return bankDetail;
    }

    public void setBankDetail(BankDetail bankDetail) {
        this.bankDetail = bankDetail;
    }
    
    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }
}
