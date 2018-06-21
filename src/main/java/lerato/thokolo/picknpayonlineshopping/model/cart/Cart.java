/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lerato.thokolo.picknpayonlineshopping.model.cartitem.CartItem;

/**
 *
 * @author User
 */

public class Cart implements Serializable{
    
    private List<CartItem> cartItems = new ArrayList<>();

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
    
    public int getSize(){
    
        return this.cartItems.size();
    }
    
    public CartItem addToCart(CartItem cartItem) {
        
       // String response = "";

        if (this.getCartItems().isEmpty()) {

            this.getCartItems().add(cartItem);
            
           // response = cartItem.getProduct().getName() + " added successfully!!";

        } else if (!this.getCartItems().isEmpty()) {

            for (int i = 0; i < this.getSize(); i++) {

                if (this.getCartItems().get(i).getProduct().getName().
                        equalsIgnoreCase(cartItem.getProduct().getName())) {

                    this.getCartItems().remove(this.getCartItems().get(i));
                }
            }
            this.getCartItems().add(cartItem);
            
             //response = cartItem.getProduct().getName() + " quantity updated successfully!!";
        }

        return cartItem; //response;
    }
    
    public CartItem removeCartItem(CartItem cartItem) {

        for (int i = 0; i < this.getSize(); i++) {

            if (this.getCartItems().get(i).getProduct().getName().equalsIgnoreCase(cartItem.getProduct().getName())) {

                if (this.getCartItems().get(i).getCount() == 1) {

                    this.getCartItems().remove(this.getCartItems().get(i));

                } else if (this.getCartItems().get(i).getCount() > 1) {

                    this.getCartItems().get(i).setCount(this.getCartItems().get(i).getCount() - 1);
                }
            }
        }
        
        return cartItem;
    }
    
    public String removeAll() {

        this.getCartItems().removeAll(this.getCartItems());
        
        return "Cart cleared";
    }
    
    public double getTotalPrice(){
    
        double grandTotal = 0;
        
        for (int i = 0; i < this.getSize(); i++) {
            
            grandTotal += this.getCartItems().get(i).getProduct().getUnitPrice()
                    * this.getCartItems().get(i).getCount();
           
        }
        
        return grandTotal;
    }
}
