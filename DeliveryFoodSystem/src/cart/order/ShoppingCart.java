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
    private int totalPrice=0;
    private int countProductInCart = 0;

    public ShoppingCart() {
        cart = new CartProduct[10];
    }

    public CartProduct[] getCartFromShoppingCart() {
        return cart;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void addProdToCart(Product prod, int quantity) {
        cart[countProductInCart++] = new CartProduct(prod, quantity);
    }

    public void removeProdFromCart(Product prod) {
        for (int j = 0; j < cart.length; j++) {
            if (cart[j].getProd().equals(prod)) {
                cart[j] = null;
            }
        }
        CartProduct[] temp = new CartProduct[cart.length];
        
        for (int i = 0; i < cart.length; i++) {
            if (cart[i]!= null) {
                int k =0;
                temp[k++] =cart[i];
            }
        }
        cart = temp;
        countProductInCart--;
    }

    public void checkOut() {

    }

    public void calTotalPrice() {
        for (int i = 0; i < cart.length; i++) {
            totalPrice += cart[i].getCartPrice();
        }
    }

    @Override
    public String toString() {
        StringBuilder shopcartString = new StringBuilder();
        shopcartString.append(super.toString());
        shopcartString.append(" shopCart { ");
        for (int i = 0; i < cart.length; i++) {
            shopcartString.append(cart[i] + "}\n");
        }
        return shopcartString.toString();
    }

}
