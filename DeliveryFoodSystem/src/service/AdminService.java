/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import product.Product;
import acc.AdminAccount;

/**
 *
 * @author tanaw
 */
public interface AdminService {
    public abstract boolean addProduct(Product prod);
    public abstract boolean removeProduct(int index);
    public abstract boolean setPriceProduct( Product prod, int price);

    
}
