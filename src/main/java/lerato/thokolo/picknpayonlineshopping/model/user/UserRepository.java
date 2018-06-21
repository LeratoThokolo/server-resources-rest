/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User
 */
public interface UserRepository extends JpaRepository<User, Integer>{

    public Optional<User> findByUserName(String userName);

    //public User findByUsername(String userName);
    
}
