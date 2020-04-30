
import DBservice.DatabaseSystem;
import java.util.Iterator;
import java.util.Scanner;
import cart.order.ShoppingCart;
import java.util.Arrays;
import person.PersonProfile;
import product.Product;
import service.Restaurant;
import acc.Account;
import acc.AdminAccount;
import acc.CustomerAccount;
//<<<<<<< HEAD
//test

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

//    private DatabaseSystem testDB;
    private AdminAccount testAdmin;
    private CustomerAccount testCustomer;
    private Product[] testProduct;
//    private ShoppingCart[] cart;
//    private Order[] testOrder;
    private Restaurant testRestuarant;
    private static final Scanner sc = new Scanner(System.in);

    public FoodDeliverySystem(String resName, String resLocation, AdminAccount admin) {
        this.testRestuarant = new Restaurant(resName, resLocation, 10);
        this.testProduct = testRestuarant.getProduct();
        this.testAdmin = admin;
    }

    public static void main(String[] args) {
        PersonProfile person = new PersonProfile("tein1142", "BNK", "0874444444");
        AdminAccount admin = new AdminAccount("username", "pass", person);
        FoodDeliverySystem system = new FoodDeliverySystem("Tein Res&Bar", "BNK",admin);

        system.signIn();

    }

     public void signIn() {
        int menuId;
        do {
            System.out.println("<<Choose your account>>");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Sign In ");

            System.out.println("0. Exit ");

            System.out.print("Enter your menu [0-2]: ");
            menuId = sc.nextInt();
            switch (menuId) {
                case 0:
                    break;

                case 1:
//                    signInAdmin();
                    adminMenu();
                    break;

                case 2:
                    signInCustomer();
                    break;

            }

        } while (menuId != 0);
        System.out.println("----------good bye!----------");
    }

    private void signInAdmin() {
        int menuId;
        do {
            System.out.println("<<Admin Menu>>");

            System.out.println("1. Login");

            System.out.println("0. Exit ");
            System.out.println("Enter your menu [0-2]: ");
            menuId = sc.nextInt();
            switch (menuId) {
                case 0:
                    break;
                case 1:
                    loginAdmin();
                    break;
                case 2:
                    registerCustomer();
                    break;

            }
        } while (menuId != 0);

    }

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
                    break;
                case 2:
                    registerCustomer();
                    break;

            }
        } while (menuId != 0);
    }

    private void loginAdmin() {//Complete
        String username;
        String password;
        boolean checkLogin;
            System.out.println("<<Login>>");
            System.out.println("Enter Username : ");
            username = sc.next();
            System.out.println("Enter Password : ");
            password = sc.next();
            
            testAdmin = new AdminAccount(username, password, DatabaseSystem.getPersonFromDB(username, password));
            checkLogin = testRestuarant.login(testAdmin, username, password);
            if (checkLogin != true) {
                System.out.println("Login Failed!");
            }else {
                System.out.println("----------Login Successful----------");
                adminMenu();
            }
    }

    private void loginCustomer() {//Complete
        String username;
        String password;
        boolean checkLogin;
            System.out.println("<<Login>>");
            System.out.println("Enter Username : ");
            username = sc.next();
            System.out.println("Enter Password : ");
            password = sc.next();
            
            testCustomer = new CustomerAccount(username, password, DatabaseSystem.getPersonFromDB(username, password));
            checkLogin = testRestuarant.login(testCustomer, username, password);
           if (checkLogin != true) {
                System.out.println("Login Failed!");
            }else {
                System.out.println("----------Login Successful----------");
                customerMenu();
            }
    }

    private void registerCustomer() {//Complete
        String username;
        String password;
        String name;
        String address;
        String phone;
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
        System.out.println("----------Register Complete----------");
    }
    public void adminMenu() {
        int menuId;
        do {
            System.out.println("<<Admin Menu>>");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");

            System.out.println("3. Show Product");
            System.out.println("4. Set Price Product");
            System.out.println("0. Exit ");
            System.out.println("Enter your menu [0-4]: ");
            menuId = sc.nextInt();
            int index;
            switch (menuId) {
                case 0:
                    break;
                case 1:
                    addProduct();
                    break;
                case 2:

                    showProduct();
                    removeProduct();

                    break;
                case 3:
                    showProduct();
                    break;
                case 4:
                    setPriceProduct();
                    break;

            }
        } while (menuId != 0);
    }

    public void customerMenu() {
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
                    showCart();
                    addProductToCart();
                    break;
                case 2:
                    removeProductFormCart();
                    break;
                case 3:
                    checkPriceFormCart();
                    break;
                case 4:
                    checkoutOrder();
                    break;

            }
        } while (menuId != 0);
    }

   

    private void addProductToCart() {
        showProduct();
        System.out.println("Enter product Id: ");
        int choose = sc.nextInt();
        System.out.println("Enter amount : ");
        int quantity = sc.nextInt();
        this.testRestuarant.addProductToCart(this.testProduct[choose - 1], quantity);
    }

    private void showProduct() {
        Product[] prod = testRestuarant.getProduct();
        for (int i = 0; i < prod.length; i++) {
            if (prod[i] != null) {
                System.out.println((i + 1) + ". " + prod[i]);

            }
        }
    }

    private void addProduct() {
        int Id;
        String name;
        int price;
        boolean canAdd;
        do {
            System.out.println("<<Product>>");
            System.out.println("ID : ");
            Id = sc.nextInt();
            System.out.println("name: ");
            name = sc.next();
            System.out.println("Price : ");
            price = sc.nextInt();

            Product prod = new Product(Id, name, price);
            canAdd = testRestuarant.addProduct(prod);
        } while (canAdd != true);
        System.out.println("----------Added Complete----------");
    }

    private void setPriceProduct() {
        System.out.println("Enter Number Set Price Product:");
        int choose = sc.nextInt();
        System.out.println("Enter Price Product:");
        int price = sc.nextInt();
        testRestuarant.setPriceProduct(testProduct[choose-1], price);
        System.out.println("-------------Set Price Complete-----------");
    }

    private void removeProduct() {
        System.out.println("Enter Number Remove Product:");
        int choose = sc.nextInt(); sc.nextLine();
        testRestuarant.removeProduct(choose);
        System.out.println("-------------Removed Complete-----------");
    }

    private void removeProductFormCart() {
        showProduct();
        System.out.println("Enter product Id: ");
        int choose = sc.nextInt();
        for (int i = 0; i < testProduct.length; i++) {
//            testCustomer.getMyShoppingCart().getProductFromCart()[choose].getProd().getProductId()==choose;
            if (testCustomer.getMyShoppingCart().getProductFromCart()[choose].getProd().getProductId()== choose) {
                
            }
            Product product = testProduct[i];
            
        }
        this.testRestuarant.removeProductFormCart(prod);
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void checkPriceFormCart() {
        showProduct();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void checkoutOrder() {
        showProduct();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ShoppingCart showCart() {
        ShoppingCart cart = testRestuarant.getShoppingFromCustomer();
        if(cart ==null) {
            System.out.println("No Product In Cart!");
            return null;
        }
            
//        for (int i = 0; i < myList.length; i++) { 
//            if (myList[i] != null) {
//                System.out.println((i+1) + ". "+myList[i].toString());
//            }
//        }
        return cart;
    }

}
