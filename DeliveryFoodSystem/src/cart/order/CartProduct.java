/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart.order;

import product.Product;

/**
 *
 * @author tanaw
 */
public class CartProduct {
    private Product prod;
    private int quantity;
    private int cartPrice;

    public CartProduct() {
    }
    
    public CartProduct(Product prod, int quantity){
        this.prod=prod;
        this.quantity = quantity;
        this.cartPrice = prod.getPrice()*quantity;
    }
    
    public int getCartPrice(){
        return cartPrice;
    }

    public Product getProd() {
        return prod;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "CartProduct{" + "prod=" + prod + ", quantity=" + quantity + ", cartPrice=" + cartPrice + '}';
    }


    
}
