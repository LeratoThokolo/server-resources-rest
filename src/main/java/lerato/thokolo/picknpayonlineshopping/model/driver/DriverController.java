/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.driver;

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
@RequestMapping("/driver")
public class DriverController {
    
    @Autowired
    private DriverService driverService;
    
    
    @RequestMapping(value = "/create-driver", method = RequestMethod.POST)
    public String createDriver(@RequestBody Driver driver){
    
        if( driver != null){
        
            this.driverService.registerDriver(driver);
        }
       
        return "Driver successfully saved!!";
    }
    
    
    @RequestMapping(value = "/all-drivers", method = RequestMethod.GET)
    public List<Driver> drivers(){
    
        return driverService.drivers();
    }
    
    @RequestMapping(value = "/single-driver/{driverID}", method = RequestMethod.GET)
    public Driver driver(@PathVariable int driverID){
    
        return this.driverService.getDriver(driverID);
    }
    
    @RequestMapping(value = "/delete-driver/{driverID}", method = RequestMethod.DELETE)
    public void deleteDriver(@PathVariable int driverID){
    
        this.driverService.deleteDriver(driverID);
    }
    
    @RequestMapping(value = "/update-driver", method = RequestMethod.PUT)
    public Driver updateDriver(@RequestBody Driver driver){
    
       return this.driverService.updateDriver(driver);
    }
}
