package service;

import DBservice.DatabaseSystem;
import cart.order.ShoppingCart;
import product.Product;
import acc.Account;
import acc.AdminAccount;
import acc.CustomerAccount;
import cart.order.SlotCart;



public class Restaurant implements CustomerService, AdminService, LoginService {
  
    private DatabaseSystem DBsystem = new DatabaseSystem();
    private String restaurantName;
    private String location;
    private Product[] product;
    private CustomerAccount customer;
    private AdminAccount admin;
    private RestaurantStatus restaurantStatus;
    
    private int countProduct = 0;
    
    public Restaurant(String restaurantName, String location) {
        this.product = DBsystem.showProductDB();
        countProduct =  DBsystem.showProductDB().length;
        this.restaurantName = restaurantName;
        this.location = location;
        this.restaurantStatus = restaurantStatus.OPEN;
    }

    public AdminAccount getAdmin() {
        return admin;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getLocation() {
        return location;
    }

    public Product[] getProduct() {
        return DBsystem.showProductDB();
    }

    public ShoppingCart getShoppingCartFromCustomer() {
        return customer.getMyShoppingCart();
    }

//    CustomerService
    @Override
    public ShoppingCart addProductToCart(Product prod, int quantity) {
        customer.addProductToCart(prod, quantity);
        return customer.getMyShoppingCart();
    }

    @Override
    public ShoppingCart removeProductFormCart(SlotCart slot) {
        customer.removeProductFormCart(slot);
        return customer.getMyShoppingCart();
    }

    @Override
    public int checkPriceFormCart() {
        return customer.checkPriceFormCart();
    }

    @Override
    public void checkoutOrder() {
        this.customer.checkoutOrder();
    }

    //Admin service
    @Override
    public boolean addProduct(Product prod) {
        if (countProduct >= product.length) {
            Product[] temp = new Product[product.length + 10];
            for (int i = 0; i < product.length; i++) {
                temp[i] = product[i];
            }
            this.product = temp;
        }
        DBsystem.addProdToDB(prod);
        this.product[countProduct++] = prod;
        return true;
    }

    @Override
    public boolean removeProduct(int index) {
        boolean remove = DBsystem.removeProduct(product[index-1]);
        
        product[index-1] = null;
        int k = 0;
        Product[] temp = new Product[product.length];
        for (int i = 0; i < product.length; i++) {
            if (product[i]!= null) {
                
                temp[k++] =product[i];
            }
        }
        product = temp;
        countProduct--;
        return remove;
    }

    @Override
    public boolean setPriceProduct(Product prod, int price) {
        if (prod == null) {
            return false;
        }
        for (int i = 0; i < product.length; i++) {
            if (product[i]!=null) { 
                if (product[i].equals(prod)) {
                product[i].setPrice(price);
                }
            }
        }
        DBsystem.setPriceDB(prod,price);
        
        return true;
    }

    @Override
    public boolean login(Account acc, String user, String pass) {
        if (acc instanceof CustomerAccount) {
            boolean checkLogin = DBsystem.loginDB_Cus(user, pass);
            CustomerAccount cus_login = new CustomerAccount(user, pass, DBsystem.getPersonFromDB(user, pass));

            if (checkLogin == false || DBsystem.getPersonFromDB(user, pass) == null) {
                return false;
            }
            this.customer = cus_login;
            return true;

        } else {
            boolean checkLogin = DBsystem.loginDB_Admin(user, pass);
            AdminAccount admin_login = new AdminAccount(user, pass, DBsystem.getPersonFromDB(user, pass));

            if (checkLogin == false || DBsystem.getPersonFromDB(user, pass) == null) {
                return false;
            }

            this.admin = admin_login;
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