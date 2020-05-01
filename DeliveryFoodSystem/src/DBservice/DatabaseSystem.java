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
import person.PersonProfile;
import product.Product;

/**
 *
 * @author tanaw
 */
public class DatabaseSystem {

    public  Connection ConnectDB() {
        String url = "jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC";
        String hostname = "tein1142@projectcompro";
        String password = "Tein62130500066";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, hostname, password);

            return con;

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        return null;

    }

    public boolean loginDB_Cus(String user, String pass) {//Complete
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {
            ResultSet cus_rs = stm.executeQuery("SELECT username,password FROM cus_account where username = '" + user + "' and password = '" + pass + "'");
                return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    public boolean loginDB_Admin(String user, String pass) {//Complete
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {
            ResultSet rs =stm.executeQuery("SELECT username,password FROM admin_account where username = '" + user + "' and password = '" + pass + "'");    
                return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    public PersonProfile getPersonFromDB(String username, String password) {//Complete
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {

            ResultSet persons = stm.executeQuery("select name,address,phone from cus_account where username = '" + username + "' and password = '" + password + "'");
            while (persons.next()) {
                String name = persons.getString("name");
                String address = persons.getString("address");
                String phone = persons.getString("phone");

                PersonProfile person = new PersonProfile(name, address, phone);

                return person;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        };
        return null;
    }

    public  boolean registerDB(String username, String password, String name, String address, String phone) {//Complete
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {

            stm.executeUpdate("INSERT INTO cus_account VALUES('" + username + "','" + password + "','" + name + "','" + address + "','" + phone + "')");
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public Product[] showProductDB() {
        int count = 0;
        int i = 0;
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {
            ResultSet item = stm.executeQuery("SELECT * FROM compro.product");
            while (item.next()) {
                count++;
            }
            Product[] temp = new Product[count];
            ResultSet item2 = stm.executeQuery("SELECT * FROM compro.product");
            while (item2.next()) {
                int idproduct = item2.getInt("idproduct");
                String pdName = item2.getString("product_name");
                int pdPrice = item2.getInt("product_price");

                temp[i] = new Product(idproduct, pdName, pdPrice);
                i++;
            }
            return temp;

        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean removeProduct(Product prod) {
        int idproduct = prod.getProductId();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {
            stm.executeUpdate("delete from compro.product where idproduct = " + idproduct + "");

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public void addProdToDB(Product prod) {
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {
            stm.executeUpdate("INSERT INTO compro.product VALUES(" + prod.getProductId() + ",'" + prod.getProductName() + "'," + prod.getPrice() + ")");
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }

    }


    public void setPriceDB(Product prod, int price) {
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {
            stm.executeUpdate("update compro.product set product_price = "+price+" where idproduct = "+prod.getProductId()+" ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

}
