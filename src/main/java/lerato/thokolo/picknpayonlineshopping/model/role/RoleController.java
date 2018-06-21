/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.role;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */

@RequestMapping("/role")
@RestController()
public class RoleController {
    
    @Autowired
    private RoleRepository roleRepository;
    
   
    @RequestMapping(value = "/admin/all-roles", method = RequestMethod.GET)
    public List<Role> getAllRoles(){
        
        return roleRepository.findAll();
    }
    
    
    @RequestMapping(value = "/admin/add-role", method = RequestMethod.POST)
    public String addRole(@RequestBody Role role){
    
        roleRepository.save(role);
        
        return "Role successfully added!!";
    }
}
