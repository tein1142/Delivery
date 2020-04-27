/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart.order;

import product.Product;
import service.CustomerService;

/**
 *
 * @author tanaw
 */
public class ShoppingCart {
    private CartProduct[] cart;
    private int totalPrice;
    private int countProductInCart =0;

    public ShoppingCart(int maxCart) {
        cart = new CartProduct[maxCart];
    }


    public CartProduct[] showProdFromCart() {
        return cart;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean addProdToCart(Product prod, int quantity){
        cart[countProductInCart++] = new CartProduct(prod, quantity);
        return true;
    }
    
    public boolean removeProdFromCart(Product prod){
        for (int i = 0; i < cart.length; i++) {
            if (cart[i].getProd().equals(prod)) {
                cart[i] = null;
            }
            return true;
        }
        return false;
    }
    
    public void checkOut(){
        
    }
    
    public int calTotalPrice(){
        for (int i = 0; i < cart.length; i++) {
                totalPrice += cart[i].getCartPrice();
        }
        return totalPrice;
    }

    
    @Override
    public String toString() {
        return "ShoppingCart{" + "cart=" + cart + ", totalPrice=" + totalPrice +  '}';
    }
    
  
    
}
