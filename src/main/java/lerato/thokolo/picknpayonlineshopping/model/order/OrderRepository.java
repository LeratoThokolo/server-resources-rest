/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.order;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
    
}
