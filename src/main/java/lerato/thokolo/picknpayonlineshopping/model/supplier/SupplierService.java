/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.supplier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lerato.thokolo.picknpayonlineshopping.model.role.Role;
import lerato.thokolo.picknpayonlineshopping.model.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void addSupplier(Supplier supplier) {

        Role role = roleRepository.getOne(2);

        String roleName = role.getName();
        role.setName(roleName);

        Set<Role> roles = new HashSet<Role>() {
            {

                add(role);
            }
        };

        supplier.setRoles(roles);

        this.supplierRepository.save(supplier);

    }

    public Supplier registerSupplier(Supplier supplier) {

        Role role = roleRepository.getOne(2);

        String roleName = role.getName();
        role.setName(roleName);

        Set<Role> roles = new HashSet<Role>() {
            {

                add(role);
            }
        };

        supplier.setRoles(roles);

        this.supplierRepository.save(supplier);

        return supplier;
    }

    public void deleteSupplier(int supplierID) {

        supplierRepository.deleteById(supplierID);
    }

    public Supplier delete(int supplierID) {

       Supplier s = this.supplierRepository.getOne(supplierID);
       
       this.supplierRepository.delete(s);
       
       return s;
    }

    public List<Supplier> allSuppliers() {

        return this.supplierRepository.findAll();
    }
}
