
import java.util.Arrays;
import java.util.Scanner;
import cart.order.ShoppingCart;
import person.PersonProfile;
import product.Beverage;
import product.Food;
import product.Product;
import service.Restaurant;
import user.AdminAccount;
import user.CustomerAccount;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tanaw
 */
public class test {
    private static AdminAccount testAdmin;
    private static CustomerAccount testCustomer;
    public static Product[] testProduct;
    private static ShoppingCart[] cart;
      private static Restaurant testRestuarant;
//    private Order[] testOrder;

    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
      
        System.out.println("hi");
        String username = "sayhi";
        String password = "1111";
        PersonProfile person = new PersonProfile("g", "f", "d");
        CustomerAccount cus_acc = new CustomerAccount(username, password, person);
//         Product pdt1 = new Food(1,"Soup",40);
//        Product pdt2 = new Food(2,"Pizza",105);
//        Product pdt3 = new Beverage(3,"Bubble Tea",35);
//        Product pdt4 = new Beverage(4,"Coffee",35);
//        Restaurant res = new Restaurant("name", "location", 10);
//        Product[] testProduct = {pdt1,pdt2,pdt3,pdt4};
//        res.addProduct(pdt2);

 


    }
    
    
//    public static PersonProfile showPerson(){
//        PersonProfile person = selectPersonFromDB();
//        return person;
//    }
    public static PersonProfile selectPersonFromDB(){
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        String add = sc.next();
        String tel = sc.next();
        PersonProfile person = new PersonProfile(name, add, tel);
        return person;
    }
    
}
