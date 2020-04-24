/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import order.Order;
import order.ShoppingCart;
import product.Product;
import user.CustomerAccount;

public interface CustomerService {
    abstract public ShoppingCart addProductToCart(Product prod, int quantity);
    abstract public boolean removeProductFormCart(Product prod, ShoppingCart cart);
    abstract public int checkPriceFormCart(ShoppingCart cart);
    abstract public Order checkoutOrder(ShoppingCart cart, CustomerAccount customer);//print bill from cart.

}
