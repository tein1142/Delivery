/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import person.PersonProfile;
import product.Product;
import acc.Account;
import acc.CustomerAccount;

/**
 *
 * @author tanaw
 */
public class DatabaseSystem {


    public static void main(String[] args) {
        Product test = new Product(5, "sus", 100);
        Product[] product ;
//        addProdToDB(test);
        product = new Product[10];
        product = showProductDB();
        System.out.println(product.length);
                System.out.println(Arrays.toString(product));
         product = new Product[product.length+10];
         System.out.println(product.length);
//        System.out.println(showProductDB().length);
        System.out.println(Arrays.toString(product));
//        ConnectDB();
//    System.out.println(loginDB("tein114", "1234"));
//       System.out.println(registerDB("zunisa", "1234", "zunisa", "bnk", "48"));
//        System.out.println(getPersonFromDB("tein1142", "1234"));
//        CustomerAccount cus = new CustomerAccount("tein1142", "1234",getPersonFromDB("tein1142", "1234"));
//        PersonProfile pr = new PersonProfile("a", "b", "c");
//        Account ac = new CustomerAccount("un", "pass", pr);
//        showItemDB();
    
    }

    

    public static Connection ConnectDB() {
        String url = "jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC";
        String hostname = "tein1142@projectcompro";
        String password = "Tein62130500066";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, hostname, password);
//            System.out.println("Database Connection Success");
            return con;

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static boolean loginDB_Cus(String user, String pass) {//Complete
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {
            ResultSet cus_rs = stm.executeQuery("SELECT username,password FROM cus_account where username = '"+user+"' and password = '"+pass+"'");
             while (cus_rs.next()) {
            String usercheck = cus_rs.getString("username");
            String passcheck = cus_rs.getString("password");
                 return true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    public static boolean loginDB_Admin(String user, String pass) {//Complete
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {
            ResultSet admin_rs = stm.executeQuery("SELECT username,password FROM admin_account where username = '"+user+"' and password = '"+pass+"'");
             while (admin_rs.next()) {
            String usercheck = admin_rs.getString("username");
            String passcheck = admin_rs.getString("password");
                 return true;
             }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    public static PersonProfile getPersonFromDB(String username, String password) {//Complete
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {

            ResultSet persons = stm.executeQuery("select name,address,phone from cus_account where username = '" + username + "' and password = '" + password + "'");
            while (persons.next()) {
                String name = persons.getString("name");
                String address = persons.getString("address");
                String phone = persons.getString("phone");
//                System.out.println(name +" "+address +" "+phone);
                PersonProfile person = new PersonProfile(name,address,phone);
//                return true;
                return person;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        };
//            return false;
        return null;
    }

    public static boolean registerDB(String username, String password, String name, String address, String phone) {//Complete
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {

             stm.executeUpdate("INSERT INTO cus_account VALUES('" + username + "','" + password + "','" + name + "','" + address + "','" + phone + "')");
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public static Product[] showProductDB(){
        int count =0 ;
        int i =0;
         try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {
            ResultSet item = stm.executeQuery("SELECT * FROM compro.product");
            while (item.next()) {
                count++;
            }
            Product[] temp = new Product[count];
            ResultSet item2 = stm.executeQuery("SELECT * FROM compro.product");
            while (item2.next()) {
                int idproduct= item2.getInt("idproduct");
                String pdName = item2.getString("product_name");
                int pdPrice= item2.getInt("product_price");
                
                temp[i] = new Product(idproduct, pdName, pdPrice);
                i++;
            }
                return temp;
                
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSystem.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
    public static boolean removeProduct(Product prod){
//         if (idproduct == 0) {  
//                        System.out.println("Failed");
//                        return false;
//                    }
            int idproduct = prod.getProductId();
         try (Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {
              stm.executeUpdate("delete from compro.product where idproduct = "+ idproduct +"");
//            System.out.println("Delete Success");
           return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public static void addProdToDB(Product prod) {
         try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {
            stm.executeUpdate("INSERT INTO compro.product VALUES(" + prod.getProductId() + ",'" + prod.getProductName() + "'," + prod.getPrice() + ")");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSystem.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
    }

    public void setPriceDB(Product prod, int price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

