/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import person.PersonProfile;
import java.beans.Customizer;
import java.util.Scanner;
import order.Order;
import order.ShoppingCart;
import product.Product;
import service.AdminService;
import service.CustomerService;


public class CustomerAccount extends Account{
    private ShoppingCart cart;

    public CustomerAccount(Account account) {
        super(account);
    }

    public CustomerAccount(String username, String password, PersonProfile person) {
        super(username, password, person);
    }

    public boolean login(String user, String pass) {
//        if (loginDB(user, pass)==true) {
//            
//        }
        return false;
    }
    
     public boolean register(String username, String password, String name, String address, String phone) {
        
         return false;
    }
    
    public ShoppingCart addProductToCart(Product prod, int quantity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
