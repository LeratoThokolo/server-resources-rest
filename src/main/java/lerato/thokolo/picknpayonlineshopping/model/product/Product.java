/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lerato.thokolo.picknpayonlineshopping.model.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lerato.thokolo.picknpayonlineshopping.model.category.Category;
import lerato.thokolo.picknpayonlineshopping.model.supplier.Supplier;

/**
 *
 * @author User
 */

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productID;
    private String name;
    private boolean purchased;
    private int quantity;
    private int minimumQuantity;
    private int badgeQuantity;
    private double unitPrice;
    private String image;
    private int imageResource;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    private Category category;
    
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public Product() {
    }
    
    public Product(String json) throws IOException{
    
        Product p = new ObjectMapper().readValue(json, Product.class);
        this.productID = p.productID;
        this.name = p.name;
        this.purchased = p.purchased;
        this.quantity = p.quantity;
        this.minimumQuantity = p.minimumQuantity;
        this.badgeQuantity = p.badgeQuantity;
        this.unitPrice = p.unitPrice;
        this.image = p.image;
        this.imageResource = p.imageResource;
        this.category = p.category;
        this.supplier = p.supplier;
        
    }
    
    

    public Product(int productID, String name, boolean purchased, int quantity, int minimumQuantity, int badgeQuantity, double unitPrice, String image, int imageResource, Category category, Supplier supplier) {
        this.productID = productID;
        this.name = name;
        this.purchased = purchased;
        this.quantity = quantity;
        this.minimumQuantity = minimumQuantity;
        this.badgeQuantity = badgeQuantity;
        this.unitPrice = unitPrice;
        this.image = image;
        this.imageResource = imageResource;
        this.category = category;
        this.supplier = supplier;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int androidImage) {
        this.imageResource = androidImage;
    }
    
    

    public int getQuantity() {
        return quantity;
    }

    public int getMinimumQuantity() {
        return minimumQuantity;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
    public void setMinimumQuantity(int minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public int getBadgeQuantity() {
        return badgeQuantity;
    }

    public void setBadgeQuantity(int badgeQuantity) {
        this.badgeQuantity = badgeQuantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
