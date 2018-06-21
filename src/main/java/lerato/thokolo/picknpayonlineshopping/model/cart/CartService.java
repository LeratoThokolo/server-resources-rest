/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.cart;

import java.util.List;
import lerato.thokolo.picknpayonlineshopping.model.cartitem.CartItem;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class CartService {
    
    
    private final Cart cart = new Cart();
    
    public CartItem addToCart(CartItem cartItem){
    
        return cart.addToCart(cartItem);
    }
    
    public CartItem removeCartItem(CartItem cartItem){
    
        return cart.removeCartItem(cartItem);
    }
    
    public double getTotalPrice(){
    
        return cart.getTotalPrice();
    }
    
    public int getCartSize(){
    
        return cart.getSize();
    }
    
    public List<CartItem> getCartItems(){
    
        return cart.getCartItems();
    }
    
    public String removeAll(){
    
        return cart.removeAll();
    }
    
    
}
