
import DBservice.DatabaseSystem;
import java.util.Iterator;
import java.util.Scanner;
import order.ShoppingCart;
import person.PersonProfile;
import product.Beverage;
import product.Food;
import product.Product;
import service.Restaurant;
import user.Account;
import user.AdminAccount;
import user.CustomerAccount;
//<<<<<<< HEAD
//test
//=======

//>>>>>>> origin/master
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tanaw
 */
public class FoodDeliverySystem {
    private DatabaseSystem testDB;
    private AdminAccount testAdmin;
    private CustomerAccount testCustomer;
    private Product[] testProduct;
    private ShoppingCart[] cart;
//    private Order[] testOrder;
    private Restaurant testRestuarant;
    private static final Scanner sc = new Scanner(System.in);
    

    public FoodDeliverySystem(String resName, String resLocation, Product[] testProduct, AdminAccount admin) {
        this.testRestuarant = new Restaurant(resName, resLocation, 5);
        this.testAdmin = admin;
        this.testProduct = testProduct;
    }
    
     public static void main(String[] args) {
        Product pdt1 = new Food(1,"Soup",40);
        Product pdt2 = new Food(2,"Pizza",105);
        Product pdt3 = new Beverage(3,"Bubble Tea",35);
        Product pdt4 = new Beverage(4,"Coffee",35);
        
        Product[] Products = {pdt1,pdt2,pdt3,pdt4};
        
        PersonProfile person = new PersonProfile("tein1142", "BNK", "0874444444");
        AdminAccount admin = new AdminAccount("username", "pass", person);
        FoodDeliverySystem system = new FoodDeliverySystem("Tein Res&Bar", "BNK", Products, admin);
        
        system.signIn();
        
        
    }
    
    
//    public void adminMenu(){
//        int menuId;
//        do {
//            System.out.println("<<Admin Menu>>");
//            System.out.println("1. Add Product");
//            System.out.println("2. Remove Product");
//            System.out.println("3. Show Product");
//            System.out.println("4. Set Price Product");
////            System.out.println("3. Show Customer"); set Price
//            System.out.println("0. Exit ");
//            System.out.println("Enter your menu [0-4]: ");
//            menuId = sc.nextInt();
//            switch (menuId) {
//                case 0:
//                    break;
//                case 1:
//                    addProduct();
//                    break;
//                case 2:
//                    removeProduct();
//                    break;
//                case 3:
//                    showProduct();
//                    break;
//                case 4:
//                    setPriceProduct();
//                    break;
//                    
//            }
//        } while (menuId != 0);
//    }
    
    
    public void customerMenu(){
        int menuId;
        do {
            System.out.println("<<Customer Menu>>");
            System.out.println("1. Select Product");//{show basket(), addProduct, removeProduct}
            System.out.println("2. Remove Product Form Cart");
            System.out.println("3. check Price Form Cart");
            System.out.println("4. checkout Order");
            
            System.out.println("0. Exit ");
            System.out.println("Enter your menu [0-3]: ");
            menuId = sc.nextInt();
            switch (menuId) {
                case 0:
                    break;                
                case 1:
                    showProduct();
                    addProductToCart();
                    break;
                case 2:
//                    removeProductFormCart();//into DB
                    break;
                case 3:
//                    checkPriceFormCart();
                    break;
                case 4:
//                    checkoutOrder();
                    break;
                    
            }
        } while (menuId != 0);
    }
    
    public void signIn() {
        int menuId;
        do {
            System.out.println("<<Choose your account>>");
            System.out.println("1. Admin Sign In ");
            System.out.println("2. Customer Sign In ");
           
            System.out.println("0. Exit ");

            System.out.print("Enter your menu [0-2]: ");
            menuId = sc.nextInt();
            switch (menuId) {
                case 0:
                    break;
                    
//                case 1:
//                    signInAdmin();
//                    adminMenu();
//                    break;

                case 2:
                    signInCustomer();
                    
                    break;

            }

        } while (menuId != 0);
        System.out.println("good bye!");
    }
    
    

//    private void signInAdmin() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    private void signInCustomer() {
        int menuId;
        do {
            System.out.println("<<Customer Menu>>");
            System.out.println("1. Login");
            System.out.println("2. Register");//{show basket(), addProduct, removeProduct}

            System.out.println("0. Exit ");
            System.out.println("Enter your menu [0-2]: ");
            menuId = sc.nextInt();
            switch (menuId) {
                case 0:
                    break;
                case 1:
                    loginCustomer();
                    customerMenu();
                    break;
                case 2:
                    registerCustomer();
                    break;
                    
            }
        } while (menuId != 0);
    }

    private void loginCustomer() {//Complete
        String username;
        String password;
        boolean checkLogin ;
        do {
            System.out.println("<<Login>>");
            System.out.println("Enter Username : ");
            username = sc.next();
            System.out.println("Enter Password : ");
            password = sc.next();
            
            checkLogin = testRestuarant.login(username, password);
//            checkLogin = testDB.loginDB(username, password);

            
        } while (checkLogin != true);
        System.out.println("Login Successful");        
    }

    private void registerCustomer() {//Complete
        String username;
        String password;
        String name;
        String address;
        String phone;
//        boolean checkLogin ;
        do {
            System.out.println("<<Register>>");
            System.out.println("Username : ");
            username = sc.next();
            System.out.println("Password : ");
            password = sc.next();
            System.out.println("Name : ");
            name = sc.next();
            System.out.println("Address : ");
            address = sc.next();
            System.out.println("Tel.: ");
            phone = sc.next();
            
            
        } while (testRestuarant.register(username, password, name, address, phone) != true);
        System.out.println("Register Complete");        
    }
    
   

    private void addProductToCart() {
        System.out.println("Enter product Id: ");
        int choose = sc.nextInt();
        System.out.println("Enter amount : ");
        int quantity = sc.nextInt();
        this.testRestuarant.addProductToCart(this.testProduct[choose-1], quantity);
    }

    private void showProduct(){
        testDB.showItemDB();
//        System.out.println("---Items in Library---");
//        Iterator<Item> items = lib.iterator();
//        int i=0;
//        while (items.hasNext()) {
//            System.out.println((++i) + ". " +items.next());
//        }
//        if(i==0) return-1; 
//        else return i;
        
    }
}
