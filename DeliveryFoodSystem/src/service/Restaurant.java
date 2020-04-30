package service;

import DBservice.DatabaseSystem;
import java.util.Arrays;
import cart.order.Order;
import cart.order.ShoppingCart;
import person.PersonProfile;
import product.Product;
import acc.Account;
import acc.AdminAccount;
import acc.CustomerAccount;

enum RestaurantStatus {
    OPEN, CLOSE
}

public class Restaurant implements CustomerService, AdminService, LoginService {

    private DatabaseSystem DBsystem;
    private String restaurantName;
    private String location;
    private Product[] product;
//    private ShoppingCart shopCart;
    private CustomerAccount customer;
    private AdminAccount admin;
    private RestaurantStatus restaurantStatus;

    private int countProduct = 0;

    public Restaurant(String restaurantName, String location, int maxProduct) {
        this.product = DBsystem.showProductDB();
        countProduct = DBsystem.showProductDB().length;
        this.restaurantName = restaurantName;
        this.location = location;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getLocation() {
        return location;
    }

    public Product[] getProduct() {
        return product;
    }

    public ShoppingCart getShoppingFromCustomer() {
        return customer.getMyShoppingCart();
    }

//    CustomerService
    @Override
    public ShoppingCart addProductToCart(Product prod, int quantity) {
        customer.addProductToCart(prod, quantity);
        return customer.getMyShoppingCart();
    }

    @Override
    public ShoppingCart removeProductFormCart(Product prod) {
        customer.removeProductFormCart(prod);
        return customer.getMyShoppingCart();
    }

    @Override
    public int checkPriceFormCart() {
        return customer.checkPriceFormCart();
    }

    @Override
    public Order checkoutOrder(ShoppingCart cart, CustomerAccount customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Admin sservice
    @Override
    public boolean addProduct(Product prod) {
        if (countProduct >= product.length) {
            Product[] temp = new Product[product.length + 10];
            for (int i = 0; i < product.length; i++) {
                temp[i] = product[i];
            }
            this.product = temp;
        }
        DBservice.DatabaseSystem.addProdToDB(prod);
        this.product[countProduct++] = prod;
        return true;
    }

    @Override
    public boolean removeProduct(int index) {
        product[index-1] = null;
        
        Product[] temp = new Product[product.length];
        for (int i = 0; i < product.length; i++) {
            if (product[i]!= null) {
                int k = 0;
                temp[k++] =product[i];
            }
        }
        product = temp;

        boolean remove = DBsystem.removeProduct(product[index-1]);
        return remove;
    }

    @Override
    public boolean setPriceProduct(/*AdminAccount admin,*/Product prod, int price) {
        for (int i = 0; i < product.length; i++) {
            if (product[i].equals(prod)) {
                product[i].setPrice(price);
                DBsystem.setPriceDB(prod,price);
            }
        }
        return true;
    }

    @Override
    public boolean login(Account acc, String user, String pass) {
        if (acc instanceof CustomerAccount) {
            boolean checkLogin = DBsystem.loginDB_Cus(user, pass);
            CustomerAccount cus_login = new CustomerAccount(user, pass, DBsystem.getPersonFromDB(user, pass));

            if (checkLogin == false || DBsystem.getPersonFromDB(user, pass) == null) {
                System.out.println("Login Failed!");
                return false;
            }
            this.customer = cus_login;
            return true;

        } else {
            boolean checkLogin = DBsystem.loginDB_Admin(user, pass);
            AdminAccount cus_login = new AdminAccount(user, pass, DBsystem.getPersonFromDB(user, pass));

            if (checkLogin == false || DBsystem.getPersonFromDB(user, pass) == null) {
                System.out.println("Login Failed!");
                return false;
            }

            this.admin = cus_login;
            return true;
        }
    }

    @Override//Complete
    public boolean register(String user, String pass, String name, String address, String phone) {
        if (DBsystem.registerDB(user, pass, name, address, phone) != true || user == null || pass == null) {
            System.out.println("Register Failed Plese Register Again!");
            return false;
        }
        return true;
    }

}