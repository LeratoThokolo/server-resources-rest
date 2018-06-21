/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.bankdetail;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(value = "/bank-account")
public class BankDetailController {
    
    @Autowired
    private BankDetailService bankDetailService;
    
     
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public List<BankDetail> accounts(){
    
        return bankDetailService.accounts();
    }
    
    @RequestMapping(value = "/create-account", method = RequestMethod.POST)
    public BankDetail createAccount(@RequestBody BankDetail bankDetail){
    
        return bankDetailService.createBankAccount(bankDetail);
    }
    
    @RequestMapping(value = "/delete-account/{id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable int id){
    
        bankDetailService.deleteAccount(id);
    }
    
    @RequestMapping(value = "/delete-bank-detail/{id}", method = RequestMethod.DELETE)
    public BankDetail deleteBankDetail(@PathVariable int id){
    
        return bankDetailService.deleteBankDetail(id);
    }
    
    @RequestMapping(value = "/find-account/{id}", method = RequestMethod.GET)
    public BankDetail getAccount(@PathVariable int id){
    
        return bankDetailService.getAccount(id);
    }
    
    @RequestMapping(value = "/update-account", method = RequestMethod.PUT)
    public BankDetail updateAccount(@RequestBody BankDetail bankDetail){
    
        return bankDetailService.updateAccount(bankDetail);
    }
    
    @RequestMapping(value = "/remove-accounts", method = RequestMethod.DELETE)
    public String removeAll(){
    
        return this.bankDetailService.removeAll();
    }
}
