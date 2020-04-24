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

/**
 *
 * @author tanaw
 */
public class DatabaseSystem {


    public static void main(String[] args) {
//        ConnectDB();
//        System.out.println(loginDB("tein114", "1234"));
//        System.out.println(Register("tein1142", "1234", "zunisa", "bangkok eiei", "0877195586"));
        System.out.println(getPersonFromDB("tein1142", "1234"));
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

    static boolean loginDB(String user, String pass) {
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {
            ResultSet cus_rs = stm.executeQuery("SELECT * FROM register where username = '" + user + "' and '" + pass + "' ");
            while (cus_rs.next()) {
                System.out.println("User: " + user + " " + "Password: " + pass);
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public static PersonProfile getPersonFromDB(String username, String password) {
        //(select name , address, tel from Account);
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {

            ResultSet persons = stm.executeQuery("select name,address,phone from register where username = '" + username + "' and password = '" + password + "'");
            while (persons.next()) {
                String name = persons.getString("name");
                String address = persons.getString("address");
                String phone = persons.getString("phone");
                PersonProfile person = new PersonProfile(name,address,phone);
                return person;
//                System.out.println("ID: " + id + " " + "Password: " + pass);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        };

        return null;
    }

    public static boolean Register(String username, String password, String name, String address, String phone) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://projectcompro.mysql.database.azure.com:3306/compro?useSSL=true&requireSSL=false&serverTimezone=UTC", "tein1142@projectcompro", "Tein62130500066");
                Statement stm = conn.createStatement();) {

            int row = stm.executeUpdate("INSERT INTO register VALUES('" + username + "','" + password + "','" + name + "','" + address + "','" + phone + "')");
            System.out.println(row);
            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

}

