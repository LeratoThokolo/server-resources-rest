/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.bank;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class BankService {
    
    @Autowired
    private BankRepository bankRepository;
    
    public void createBank(Bank bank){
    
        bankRepository.save(bank);
    }
    
    public List<Bank> banks(){
    
        return bankRepository.findAll();
    }
    
    public void deleteBank(int bankID){
    
        bankRepository.deleteById(bankID);
        
    }
}
