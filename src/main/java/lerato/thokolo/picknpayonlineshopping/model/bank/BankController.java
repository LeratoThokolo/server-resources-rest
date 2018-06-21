/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.bank;

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
@RequestMapping("/bank")
public class BankController {
    
    @Autowired
    private BankService bankService;
    
    @RequestMapping(value = "/banks", method = RequestMethod.GET)
    public List<Bank> banks(){
    
        return bankService.banks();
    }
    
    @RequestMapping(value = "/save-bank", method = RequestMethod.POST)
    public void saveBank(@RequestBody Bank bank){
    
        bankService.createBank(bank);
    }
    
    @RequestMapping(value = "/delete-bank/{id}", method = RequestMethod.DELETE)
    public void deleteBank(@PathVariable int id){
    
        bankService.deleteBank(id);
    }
}
