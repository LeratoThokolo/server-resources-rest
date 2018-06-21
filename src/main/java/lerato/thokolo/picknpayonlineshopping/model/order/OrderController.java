/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.order;

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
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/create-order", method = RequestMethod.POST)
    public void createOrder(@RequestBody Order order) {

        orderService.createOrder(order);
    }
    
    @RequestMapping(value = "/order-create", method = RequestMethod.POST)
    public Order create(@RequestBody Order order) {

        return orderService.create(order);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> getOrders() {

        return orderService.getOrders();
    }

    @RequestMapping(value = "/single-order/{id}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable int id) {

        return orderService.getOrder(id);
    }

    @RequestMapping(value = "/delete-order/{id}", method = RequestMethod.DELETE)
    public void removeOrder(@PathVariable int id) {

        orderService.deleteOrder(id);
    }

    @RequestMapping(value = "/update-order", method = RequestMethod.PUT)
    public Order updateOrder(@RequestBody Order order) {

        return orderService.updateOrder(order);
    }

    @RequestMapping(value = "/customer-orders/{customerID}", method = RequestMethod.GET)
    public List<Order> customerOrders(@PathVariable int customerID) {

        return this.orderService.getCustomerOrders(customerID);

    }
    
    @RequestMapping(value = "/get-orders", method = RequestMethod.GET)
    public List<Order> getOrdersList() {

        return this.orderService.getOrdersList();

    }
    
    @RequestMapping(value = "/get-driver-orders/{driverID}", method = RequestMethod.GET)
    public List<Order> getOrdersListByDriverID(@PathVariable int driverID) {

        return this.orderService.getOrdersListByDriverID(driverID);

    }

    /*
    @RequestMapping(value = "/user-order-by-email/{email}", method = RequestMethod.DELETE)
    public Order getOrderByEmail(@PathVariable String email){
    
        return orderService.getOrderByEmail(email);
    }
     */
}
