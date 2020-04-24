/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBservice;

import person.PersonProfile;

/**
 *
 * @author tanaw
 */
public class DatabaseSystem {
    //Connection();
//    boolean loginDB(String user, String pass){
//        return false;
//    }
    
    public PersonProfile getPersonFromDB(String username, String password){
        //(select name , address, tel from Account);
        
        PersonProfile person = new PersonProfile("AAA", "BBB", "CCC");
        return person;
    }
//    boolean Register();
    
    
}
