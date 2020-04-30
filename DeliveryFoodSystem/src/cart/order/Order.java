/*  * To change this license header, choose License Headers in Project Properties.  
* To change this template file, choose Tools | Templates  * and open the template in the editor.  */ 
package cart.order;  
import java.io.BufferedOutputStream; 
import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.DataOutputStream; 
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.FileReader; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.PrintWriter; 
import product.Product;  
/**  *  * @author tanaw  */ 
public class Order {         
    public static void writeOrder(SlotCart cart) {         
        try (FileWriter fw = new FileWriter("order.txt");              
                BufferedWriter bw=new BufferedWriter(fw);) {                      
            bw.write("ProductID:"+cart.getProd().getProductId()+
                    "\t"+cart.getProd().getProductName()+
                    "\t price each product: "+cart.getProd().getPrice()+
                    "\t quantity : "+cart.getQuantity()+
                    "\t pric: "+cart.getProd().getPrice()+" bath \n"+                     
                    "Totalprice = "+cart.getCartPrice()+" bath");
        } catch (FileNotFoundException ex) {             
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        } 
        catch (IOException ex) {             
            ex.printStackTrace();    
            System.out.println(ex.getMessage());
        }     
    } 
    
    public static void readOrder(SlotCart cart) {         
        try (FileWriter fw = new FileWriter("order.txt");              
                BufferedWriter bw=new BufferedWriter(fw);) {                      
            bw.write("ProductID:"+cart.getProd().getProductId()+
                    "\t"+cart.getProd().getProductName()+
                    "\t price each product: "+cart.getProd().getPrice()+
                    "\t quantity : "+cart.getQuantity()+
                    "\t pric: "+cart.getProd().getPrice()+" bath \n"+                     
                    "Totalprice = "+cart.getCartPrice()+" bath");
        } catch (FileNotFoundException ex) {             
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        } 
        catch (IOException ex) {             
            ex.printStackTrace();    
            System.out.println(ex.getMessage());
        }     
    }                                    
    public static void main(String[] args) {         
        Product p = new Product(131,"Mooknin",20);         
        SlotCart cart = new SlotCart(p, 5);
//        ShoppingCart sp = new ShoppingCart(5);
        
        
        System.out.println(cart.getCartPrice());
//        writeOrder(sp);              
    }                            
}