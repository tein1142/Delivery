/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import DBservice.DatabaseSystem;
import java.util.Arrays;
import order.Order;
import order.ShoppingCart;
import person.PersonProfile;
import product.Product;
import user.Account;
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
    private ShoppingCart cart;
    private CustomerAccount customer;
    private AdminAccount admin;
    private RestaurantStatus restaurantStatus;
    private int countProduct=0;

    public Restaurant(String restaurantName, String location, int maxProduct) {
        this.product = new Product[maxProduct];
        this.restaurantName = restaurantName;
        this.location = location;
    }

    

    public Product[] getProduct() {
        return product;
    }

    
//    CustomerService
    @Override
    public ShoppingCart addProductToCart(Product prod, int quantity) {
//        this.cart = new ShoppingCart[10];
//        this.cart[1] = new ShoppingCart(prod,quantity);
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
    public boolean addProduct(/*AdminAccount admin,*/ Product prod) {
        this.product[countProduct] = prod;
        countProduct++;
        System.out.println(Arrays.toString(product));
        return true;
    }

    
    public boolean removeProduct(int idproduct) {
        
        boolean remove = DBsystem.removeProduct(idproduct);
        return remove;
    }

    @Override
    public boolean setPriceProduct(/*AdminAccount admin,*/ Product prod) {
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
//    @Override//Complete
    public boolean login2(Account acc,String user, String pass) {
        if (acc instanceof CustomerAccount) {
            boolean checkLogin = DBsystem.loginDB(user, pass);
            CustomerAccount cus_login =new CustomerAccount(user, pass, DBsystem.getPersonFromDB(user, pass));
            
            if (checkLogin == false || DBsystem.getPersonFromDB(user, pass) == null) {
                System.out.println("Login Failed!");
                return false;
            }
            this.customer = cus_login;
            return true;

        } else {
            boolean checkLogin = DBsystem.loginDB2(user, pass);
            AdminAccount cus_login =new AdminAccount(user, pass, DBsystem.getPersonFromDB(user, pass));
            
            if (checkLogin == false || DBsystem.getPersonFromDB(user, pass) == null) {
                System.out.println("Login Failed!");
                return false;
            }
            
            this.admin = cus_login;
            return true;
        }
    }

    @Override//Complete
    public boolean register(String user, String pass ,String name, String address, String phone) {
        if (DBsystem.registerDB(user, pass, name, address, phone) != true || user == null || pass ==null) {
            System.out.println("Register Failed Plese Register Again!");
            return false;
        }   
        return true;
    }

    
    
    
   
}
