
import java.util.Arrays;
import product.Product;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tein1
 */


public class test {
    
//    public boolean removeProduct(int idproduct) {
//        for (int i = 0; i < products.length; i++) {
//            if (idproduct == products[i].getProductId()) {
//                products[i] = null;
//                }
//            }
//    }
    public static void main(String[] args) {
        Product pdt1 = new Product(1,"Soup",40);
        Product pdt2 = new Product(2,"Pizza",105);
        Product pdt3 = new Product(3,"Bubble Tea",35);
        Product pdt4 = new Product(4,"Coffee",35);
//        Product[] Products = {pdt1,pdt2,pdt3,pdt4};
        Product[] products = new Product[10];
        
        products[0] = pdt1;
        products[1] = pdt2;
        products[2] = pdt3;
        products[3] = pdt4;
        
        System.out.println(Arrays.toString(products));
        System.out.println(products[1].getProductId());
//        int in= 1;
//        for (int i = 0; i < 2; i++) {
//            if (in == products[in].getProductId()) {
//                products[in++] = null;
//                System.out.println("HooRay");
//                }
//            }
        
        System.out.println(Arrays.toString(products));
    }
}
