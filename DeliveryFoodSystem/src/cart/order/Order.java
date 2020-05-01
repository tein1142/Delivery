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
import person.PersonProfile;
import product.Product;  
/**  *  * @author tanaw  */ 
public class Order {         
    public static void writeOrder(ShoppingCart cart, PersonProfile person) {         
        try (FileWriter fw = new FileWriter("order.txt");              
                BufferedWriter bw=new BufferedWriter(fw);) {                      
            bw.write("************** Your Order **************"+"\n"+
                    person+"\n"+
                    cart.toString()+"\n"+
                   
                    "Totalprice : "+cart.getTotalPrice()+" bath \n"+
                    "***************************************");
        } catch (FileNotFoundException ex) {             
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        } 
        catch (IOException ex) {             
            ex.printStackTrace();    
            System.out.println(ex.getMessage());
        }     
    } 
    
    public static void readOrder() {         
        try (FileReader fr = new FileReader("order.txt");
             BufferedReader br = new BufferedReader(fr);
             PrintWriter pw = new PrintWriter(System.out);
             BufferedWriter bw = new BufferedWriter(pw);   ) {  
            
            String data;
            while ((data = br.readLine())!=null) {
                bw.write(data);
                bw.write('\n');
            }
            
        } catch (FileNotFoundException ex) {             
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        } 
        catch (IOException ex) {             
            ex.printStackTrace();    
            System.out.println(ex.getMessage());
        }     
    }                                    
}