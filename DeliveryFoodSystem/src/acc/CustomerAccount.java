/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acc;

import person.PersonProfile;
import cart.order.ShoppingCart;
import cart.order.SlotCart;
import product.Product;


public class CustomerAccount extends Account{
    private ShoppingCart shopcart;

    public CustomerAccount(Account account) {
        super(account);
    }

    public CustomerAccount(String username, String password, PersonProfile person) {
        super(username, password, person);
        this.shopcart = new ShoppingCart();
    }
    
    public ShoppingCart getMyShoppingCart() {
        return shopcart;
    }
    
    public boolean addProductToCart(Product prod, int quantity) {
        if (quantity>=0) {
            shopcart.addProdToCart(prod, quantity);
            return true;
        }else return false;
    }


    public boolean removeProductFormCart(SlotCart slot) {
        if (slot == null) {
            return false;
        }
        shopcart.removeSlotFromCart(slot);
        return true;
        
    }


    public int checkPriceFormCart() {  
        return shopcart.getTotalPrice();
    }


    public void checkoutOrder() {
        shopcart.checkOut(shopcart, getPerson());
    
    }

    @Override
    public String toString() {
        return "CustomerAccount{" +super.toString()+ '}';
    }

   
   


}
