/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.cartitem;

import java.io.Serializable;
import lerato.thokolo.picknpayonlineshopping.model.product.Product;

/**
 *
 * @author User
 */
public class CartItem implements Serializable {
    
   
    private Product product;
    private int count;

    public CartItem() {
    }

    public CartItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
