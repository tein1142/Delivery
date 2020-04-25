/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DBservice.DatabaseSystem;
import order.Order;
import order.ShoppingCart;
import product.Product;
import user.AdminAccount;
import user.CustomerAccount;

enum RestaurantStatus{
    OPEN, CLOSE
}
        
public class Restaurant implements CustomerService, AdminService, LoginService{
    private DatabaseSystem DBsystem;
    private String restaurantName;
    private String location;
    private Product[] product;
    private ShoppingCart[] cart;
    private CustomerAccount customer;
    private AdminAccount admin;
    private RestaurantStatus restaurantStatus;

    public Restaurant() {
    }

    
    //CustomerService
    @Override
    public ShoppingCart addProductToCart(Product prod, int quantity) {
        this.cart = new ShoppingCart[10];
        this.cart[1] = new ShoppingCart(prod,quantity);
        return cart;
    }

    @Override
    public boolean removeProductFormCart(Product prod, ShoppingCart cart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int checkPriceFormCart(ShoppingCart cart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order checkoutOrder(ShoppingCart cart, CustomerAccount customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Admin sservice
    @Override
    public boolean addProduct(AdminAccount admin, Product prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeProduct(AdminAccount admin, Product prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setPriceProduct(AdminAccount admin, Product prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//Complete
    public boolean login(String user, String pass) {
        boolean checkLogin = DBsystem.loginDB(user, pass);
        CustomerAccount cus_login =new CustomerAccount(user, pass, DBsystem.getPersonFromDB(user, pass));
        if (checkLogin == false || DBsystem.getPersonFromDB(user, pass) == null) {
            System.out.println("Login Failed!");
            return false;
        }
        this.customer = cus_login;
        return true;
    }

    @Override
    public boolean register(String user, String pass ,String name, String address, String phone) {
        DBsystem.registerDB(name, pass, name, address, phone);
        return false;
    }

   
}
