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
import java.util.logging.Level;
import java.util.logging.Logger;
import person.PersonProfile;
import user.Account;
import user.CustomerAccount;

/**
 *
 * @author tanaw
 */
public class DatabaseSystem {


    public static void main(String[] args) {
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

    public static boolean loginDB(String user, String pass) {//Complete
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
    public static boolean loginDB2(String user, String pass) {//Complete
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
    
    public static boolean showItemDB(){
         try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {
            ResultSet item = stm.executeQuery("SELECT * FROM product");
            while (item.next()) {
                String idproduct= item.getString("idproduct");
                String pdName = item.getString("product_name");
                String pdPrice= item.getString("product_price");
                System.out.println(idproduct+". "+"ProductName: "+pdName+"   ProductPrice: "+pdPrice);
            }
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSystem.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    public static boolean removeProduct(int idproduct){
         if (idproduct == 0) {  
                        System.out.println("Failed");
                        return false;
                    }
         try (Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {
              stm.executeUpdate("delete from compro.product where idproduct = "+idproduct+"");
            System.out.println("Delete Success");
           return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}

