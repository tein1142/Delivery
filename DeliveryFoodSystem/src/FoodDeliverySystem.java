
import DBservice.DatabaseSystem;
import java.util.Scanner;
import product.Product;
import service.Restaurant;
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

    private DatabaseSystem testDB = new DatabaseSystem();
    private AdminAccount testAdmin;
    private CustomerAccount testCustomer;
    private Product[] testProduct;
    private Restaurant testRestuarant;
    private static final Scanner sc = new Scanner(System.in);

    public FoodDeliverySystem(String resName, String resLocation) {
        this.testRestuarant = new Restaurant(resName, resLocation);
        this.testProduct = testRestuarant.getProduct();

    }

    public static void main(String[] args) {
        FoodDeliverySystem system = new FoodDeliverySystem("Tein Res&Bar", "BNK");
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
                    signInAdmin();
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
            System.out.println("2. Register");

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

        testAdmin = new AdminAccount(username, password, testDB.getPersonFromDB(username, password));
        checkLogin = testRestuarant.login(testAdmin, username, password);
        if (checkLogin != true) {
            System.out.println("Login Failed!");
        } else {
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

        testCustomer = new CustomerAccount(username, password, testDB.getPersonFromDB(username, password));
        checkLogin = testRestuarant.login(testCustomer, username, password);
        if (checkLogin != true) {
            System.out.println("Login Failed!");
        } else {
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
            switch (menuId) {
                case 0:
                    break;
                case 1:
                    showProduct();
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
            System.out.println("1. Select Product");
            System.out.println("2. Remove Product Form Cart");
            System.out.println("3. show Cart");
            System.out.println("4. check Price Form Cart");
            System.out.println("5. checkout Order");

            System.out.println("0. Exit ");
            System.out.println("Enter your menu [0-3]: ");
            menuId = sc.nextInt();
            switch (menuId) {
                case 0:
                    break;
                case 1:
                    addProductToCart();
                    break;
                case 2:
                    removeProductFormCart();
                    break;
                case 3:
                    showCart();
                    break;
                case 4:
                    checkPriceFormCart();
                    break;
                case 5:
                    checkoutOrder();
                    break;

            }
        } while (menuId != 0);
    }

    private void showProduct() {
        System.out.println("<< Product >> ");

        testProduct = testRestuarant.getProduct();
        for (int i = 0; i < testProduct.length; i++) {
            if (testProduct[i] != null) {
                System.out.println((i + 1) + ". " + testProduct[i]);

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
        testRestuarant.setPriceProduct(testProduct[choose - 1], price);
        System.out.println("-------------Set Price Complete-----------");
    }

    private void removeProduct() {
        System.out.println("Enter Number Remove Product:");
        int index = sc.nextInt();
        testRestuarant.removeProduct(index);
        System.out.println("-------------Removed Complete-----------");
    }

    private void addProductToCart() {
        showCart();
        showProduct();
        System.out.println("Enter product Id: ");
        int choose = sc.nextInt();
        System.out.println("Enter amount : ");
        int quantity = sc.nextInt();
        System.out.println("");
        if (quantity>=0) {
            this.testRestuarant.addProductToCart(this.testProduct[choose - 1], quantity);
        }else System.out.println("quantity must > 0");
        
    }

    private void removeProductFormCart() {
        showCart();
        showProduct();
        System.out.println("Enter Number Remove Product From Cart: ");
        int choose = sc.nextInt();

        testRestuarant.removeProductFormCart(testRestuarant.getShoppingCartFromCustomer().getCartFromShoppingCart()[choose - 1]);
        System.out.println("------ Removed ------");

    }

    private void checkPriceFormCart() {
        System.out.println("Total Price : " + testRestuarant.checkPriceFormCart() + " Bath");
    }

    private void checkoutOrder() {
        testRestuarant.checkoutOrder();
    }

    private void showCart() {
        System.out.println("<<< Shopping Cart >>> ");
        if (testRestuarant.getShoppingCartFromCustomer().getCartFromShoppingCart()[0] == null) {
            System.out.println("No Product");
        }
        for (int i = 0; i < testProduct.length; i++) {
            if (testRestuarant.getShoppingCartFromCustomer().getCartFromShoppingCart()[i] != null) {
                System.out.println((i + 1) + ". " + testRestuarant.getShoppingCartFromCustomer().getCartFromShoppingCart()[i]);
            }
        }
    }

}
