/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.bankdetail;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class BankDetailService {
    
    @Autowired
    private BankDetailRepository bankDetailRepository;
    
    public BankDetail createBankAccount(BankDetail bankDetail){
        
        return bankDetailRepository.save(bankDetail); 
    }
    
    public List<BankDetail> accounts(){
    
        return bankDetailRepository.findAll();
    }
    
    public BankDetail getAccount(int  id){
        
        
        return bankDetailRepository.getOne(id);
    
    }
    
    public void deleteAccount(int id){
    
        bankDetailRepository.deleteById(id);
    }
    
    public BankDetail deleteBankDetail(int bankDetailID){
    
        BankDetail bd = this.getAccount(bankDetailID);
        
        if(bd == null){
        
            return null;
        }
       
        this.bankDetailRepository.deleteById(bankDetailID);
            
            return bd;
        
    }
    
    public BankDetail updateAccount(BankDetail bankDetail){
        
        
        BankDetail bd = this.getAccount(bankDetail.getBankDetailID());
        
        if( bd == null){
            
            return null;
        }
    
        return bankDetailRepository.save(bankDetail);
    }
    
    public String removeAll(){
    
        this.bankDetailRepository.deleteAll();
        
        return "Bank details cleared";
    }
}
