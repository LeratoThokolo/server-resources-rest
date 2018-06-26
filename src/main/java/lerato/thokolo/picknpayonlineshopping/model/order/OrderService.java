/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    public void createOrder(Order order) {
        
        orderRepository.save(order);
    }
    
    public Order create(Order order) {
        
        order.setDateCreated(new Date());
        return orderRepository.save(order);
    }
    
    public Order getOrder(int id) {
        
        return orderRepository.getOne(id);
    }
    
    public void deleteOrder(int id) {
        
        orderRepository.deleteById(id);
    }
    
    public Order delete(int id) {
        
        Order o = this.getOrder(id);
        
        this.orderRepository.deleteById(id);
        
        return o;
    }
    
    
    public List<Order> getOrders() {
        
        return this.orderRepository.findAll();
    }
    
    public Order updateOrder(Order order) {
        
        Order ordered = orderRepository.getOne(order.getOrderID());
        
        if (ordered == null) {
            
            return null;
        }
        order.setDateCreated(new Date());
        return orderRepository.save(order);
    }
    
    public Order updateOrderStatus(Order order) {
        
        Order ordered = orderRepository.getOne(order.getOrderID());
        
        if (ordered == null) {
            
            return null;
        }
        
        return orderRepository.save(order);
    }
    
    public List<Order> getCustomerOrders(int customerID) {
        
        List<Order> orders = this.getOrders();
        List<Order> customerOrders = new ArrayList<>();
        
        if (!orders.isEmpty()) {
            
            for (int i = 0; i < orders.size(); i++) {
                
                if (orders.get(i).getUserID() == customerID) {
                    
                    customerOrders.add(orders.get(i));
                }
            }
            
        }
        
        return customerOrders;
        
    }
    
    public List<Order> getOrdersList() {
        
        List<Order> orders = this.getOrders();
        List<Order> notDelivered = new ArrayList<>();
        
        if (!orders.isEmpty()) {
            
            for (int i = 0; i < orders.size(); i++) {
                
                if (orders.get(i).getDelivered().equalsIgnoreCase("No")) {
                    
                    notDelivered.add(orders.get(i));
                }
            }
            
        }
        
        return notDelivered;
        
    }
    
       public List<Order> getOrdersListDelivered() {
        
        List<Order> orders = this.getOrders();
        List<Order> delivered = new ArrayList<>();
        
        if (!orders.isEmpty()) {
            
            for (int i = 0; i < orders.size(); i++) {
                
                if (orders.get(i).getDelivered().equalsIgnoreCase("Yes")) {
                    
                    delivered.add(orders.get(i));
                }
            }
            
        }
        
        return delivered;
        
    }
    
    public List<Order> getOrdersListByDriverID(int driverID) {
        
        List<Order> orders = this.getOrders();
        List<Order> driverOrders = new ArrayList<>();
        
        if (!orders.isEmpty()) {
            
            for (int i = 0; i < orders.size(); i++) {
                
                if(orders.get(i).getDriverID() == driverID){
                
                    driverOrders.add(orders.get(i));
                }
            }
            
        }
        
        return driverOrders;
        
    }

    /*
    public Order getOrderByEmail(String email) {

        List<Order> orders = this.getOrders();
        Order order = null;

        if (!orders.isEmpty()) {

            for (int i = 0; i < orders.size(); i++) {

                if (orders.get(i).getUser().getUserName().equals(email)) {

                    order = orders.get(i);
                }
            }
        }

        return order;
    }
     */
}
