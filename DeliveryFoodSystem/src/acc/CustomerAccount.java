/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acc;

import person.PersonProfile;
import java.beans.Customizer;
import java.util.Scanner;
import cart.order.Order;
import cart.order.ShoppingCart;
import product.Product;
import service.AdminService;
import service.CustomerService;


public class CustomerAccount extends Account{
    private ShoppingCart shopcart;

    public CustomerAccount(Account account) {
        super(account);
    }

    public CustomerAccount(String username, String password, PersonProfile person) {
        super(username, password, person);
    }
    
    public ShoppingCart addProductToCart(Product prod, int quantity) {
        shopcart.addProdToCart(prod, quantity);
    }


    public boolean removeProductFormCart(Product prod, ShoppingCart cart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public int checkPriceFormCart(ShoppingCart cart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public Order checkoutOrder(ShoppingCart cart, CustomerAccount customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   


}
