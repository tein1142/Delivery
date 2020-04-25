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
public class ShoppingCart {
    private Product prod;
    private int quantity;

    private int totalPrice;

    public ShoppingCart() {
    }

    public ShoppingCart(Product prod, int quantity) {
        this.prod = prod;
        this.quantity = quantity;
    }

    public Product getProd() {
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
