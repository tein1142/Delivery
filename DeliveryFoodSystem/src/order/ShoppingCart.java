/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import product.Product;
import service.CustomerService;

/**
 *
 * @author tanaw
 */
public abstract class ShoppingCart {
    private Product prod;
    private int quantity;

    private int totalPrice;

    public ShoppingCart() {
    }

    public Product getProd() {
        prod.
        return prod;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "prod=" + prod + ", quantity=" + quantity + ", totalPrice=" + totalPrice + '}';
    }
    
}
