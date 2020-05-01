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
public class SlotCart {

    private Product prod;
    private int quantity;
    private int cartPrice;

    public SlotCart() {
    }

    public SlotCart(Product prod, int quantity) {
        this.prod = prod;
        this.quantity = quantity;
        this.cartPrice = prod.getPrice() * quantity;
    }

    public int getCartPrice() {
        return cartPrice;
    }

    public Product getProd() {
        return prod;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
        this.cartPrice += quantity*prod.getPrice();
    }


    @Override
    public String toString() {
        StringBuilder cartString = new StringBuilder();
        cartString.append("Slot{" + prod);
        cartString.append("\t" +"Quantity :" + quantity);
        cartString.append("\t" +"Price :"+cartPrice +" }");   
        return cartString.toString();
    }

}
