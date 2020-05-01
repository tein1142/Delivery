/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import cart.order.Order;
import cart.order.ShoppingCart;
import product.Product;
import acc.CustomerAccount;
import cart.order.SlotCart;

public interface CustomerService {
    abstract public ShoppingCart addProductToCart(Product prod, int quantity);
    abstract public ShoppingCart removeProductFormCart(SlotCart slot);
    abstract public int checkPriceFormCart();
    abstract public void/*Order*/ checkoutOrder(/*ShoppingCart cart, CustomerAccount customer*/);

}
