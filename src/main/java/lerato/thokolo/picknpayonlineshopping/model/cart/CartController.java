/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.cart;

import java.util.List;
import lerato.thokolo.picknpayonlineshopping.model.cartitem.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    
    @Autowired
    private CartService cartService;
    
    @RequestMapping(value = "/add-item", method = RequestMethod.POST)
    public CartItem addToCart(@RequestBody CartItem cartItem){
    
        return cartService.addToCart(cartItem);
    }
    
    @RequestMapping(value = "/remove-item", method = RequestMethod.PUT)
    public CartItem removeCartItem(@RequestBody CartItem cartItem){
    
        return cartService.removeCartItem(cartItem);
    }
    
    @RequestMapping(value = "/cart-size", method = RequestMethod.GET)
    public int getCartSize(){
    
        return cartService.getCartSize();
    }
    
    
    @RequestMapping(value = "/cart-items", method = RequestMethod.GET)
    public List<CartItem> getCartItems(){
    
        return cartService.getCartItems();
    }
    
    @RequestMapping(value = "/total-price", method = RequestMethod.GET)
    public double getTotalPrice(){
    
        return cartService.getTotalPrice();
    }
    
    @RequestMapping(value = "/remove-all-items", method = RequestMethod.DELETE)
    public String removeAllItems(){
    
        return cartService.removeAll();
    }
}
