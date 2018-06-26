/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.driver;

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
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void registerDriver(Driver driver) {

        Role role = roleRepository.getOne(3);

        String roleName = role.getName();
        role.setName(roleName);

        Set<Role> roles = new HashSet<Role>() {
            {

                add(role);
            }
        };

        driver.setRoles(roles);

        driverRepository.save(driver);

    }

    public Driver addDriver(Driver driver) {

        Role role = roleRepository.getOne(3);

        String roleName = role.getName();
        role.setName(roleName);

        Set<Role> roles = new HashSet<Role>() {
            {

                add(role);
            }
        };

        driver.setRoles(roles);

        driverRepository.save(driver);

        return driver;
    }

    public void deleteDriver(int driverID) {

        driverRepository.deleteById(driverID);

    }

    public Driver delete(int userID) {

        Driver d = this.getDriver(userID);

        this.driverRepository.deleteById(userID);

        return d;
    }

    public Driver getDriver(int driverID) {

        return driverRepository.getOne(driverID);

    }

    public Driver updateDriver(Driver driver) {

        Driver d = this.getDriver(driver.getUserID());

        if (d == null) {

            return null;
        }

        return driverRepository.save(driver);
    }

    public List<Driver> drivers() {

        return this.driverRepository.findAll();
    }
}
