/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import user.Account;

/**
 *
 * @author tanaw
 */
public interface LoginService {
    
    public abstract boolean login(Account acc,String user, String pass);
    public abstract boolean register(String user, String pass ,String name, String address, String phone);
}
