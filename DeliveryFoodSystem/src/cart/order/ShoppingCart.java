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

    private SlotCart[] cart;
    private int totalPrice=0;
    private int countProductInCart = 0;

    public ShoppingCart() {
        cart = new SlotCart[10];
    }

    public SlotCart[] getCartFromShoppingCart() {
        return cart;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void addProdToCart(Product prod, int quantity) {
        cart[countProductInCart++] = new SlotCart(prod, quantity);
    }

    public void removeSlotFromCart(SlotCart slot) {
        for (int j = 0; j < cart.length; j++) {
            if (cart[j]!= null) { 
                if (cart[j].equals(slot)) {
                System.out.println("ShCart "+slot);
                cart[j] = null;
                }
            }
            
        }
        SlotCart[] temp = new SlotCart[cart.length];
        int k =0;
        for (int i = 0; i < cart.length; i++) {
            if (cart[i]!= null) {
                
                temp[k++] =cart[i];
            }
        }
        cart = temp;
        countProductInCart--;
    }

    public void checkOut() {

    }

    public void calTotalPrice() {
        int cal = 0;
        for (int i = 0; i < cart.length; i++) {
            if (cart[i]!= null) {
                cal += cart[i].getCartPrice();
            }
        }
        totalPrice = cal;
    }

    @Override
    public String toString() {
        StringBuilder shopcartString = new StringBuilder();
//        shopcartString.append(super.toString());
        shopcartString.append(" shopCart :\n");
        for (int i = 0; i < cart.length; i++) {
            shopcartString.append(cart[i] + "\n");
        }
        return shopcartString.toString();
    }

}
