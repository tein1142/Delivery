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
    private int price =0 ;

    public CartProduct() {
    }
    
    public CartProduct(Product prod, int quantity){
        this.prod=prod;
        this.quantity = quantity;
    }
    
    public int calPrice(Product prod){
        price = prod.getPrice()*quantity;
        return price;
    }

    public Product getProd() {
        return prod;
    }

    @Override
    public String toString() {
        return "CartProduct{" + "prod=" + prod + ", quantity=" + quantity + ", price=" + price + '}';
    }
    
}
