
import java.util.Scanner;
import order.ShoppingCart;
import person.PersonProfile;
import product.Product;
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
    private static Product[] testProduct;
    private static ShoppingCart[] cart;
//    private Order[] testOrder;

    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        String username = "sayhi";
        String password = "1111";
        
        CustomerAccount cus_acc = new CustomerAccount(username, password, showPerson());
        
        testCustomer = cus_acc;
        
        System.out.println(testCustomer);
    }
    public static PersonProfile showPerson(){
        PersonProfile person = selectPersonFromDB();
        return person;
    }
    public static PersonProfile selectPersonFromDB(){
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        String add = sc.next();
        String tel = sc.next();
        PersonProfile person = new PersonProfile(name, add, tel);
        return person;
    }
}
