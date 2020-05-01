/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart.order;

import acc.CustomerAccount;
import person.PersonProfile;
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
         int cal = 0;
        for (int i = 0; i < cart.length; i++) {
            if (cart[i]!= null) {
                cal += cart[i].getCartPrice();
            }
        }
        totalPrice = cal;
        return totalPrice;
    }

    public void addProdToCart(Product prod, int quantity) {
        cart[countProductInCart] = new SlotCart(prod, quantity);
        for (int i = 0; i < countProductInCart-1; i++) {
            if (cart[i]!=null) { 
//                System.out.println("1g"+cart[i].getProd());
                if (cart[i].getProd().equals(prod)) {
//                    System.out.println("2g"+cart[i].getProd());
//                    System.out.println("3g"+prod);
                cart[i].increaseQuantity(quantity);
                cart[countProductInCart] = null;
                }
            }
             
        }
        countProductInCart++;
       
    }

    public void removeSlotFromCart(SlotCart slot) {
        for (int j = 0; j < cart.length; j++) {
            if (cart[j]!= null) { 
                if (cart[j].equals(slot)) {
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

    public void checkOut(ShoppingCart cart, PersonProfile person) {
        Order.writeOrder(cart,person);
        Order.readOrder();
    }

    

    @Override
    public String toString() {
        StringBuilder shopcartString = new StringBuilder();
        shopcartString.append("shopCart\n");
        for (int i = 0; i < cart.length; i++) {
            if (cart[i]!=null) {
                shopcartString.append((i+1)+". " +cart[i] + "\n");
            }
        }
        return shopcartString.toString();
    }
}
