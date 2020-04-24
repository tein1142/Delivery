/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import product.Product;
import user.AdminAccount;

/**
 *
 * @author tanaw
 */
public interface AdminService {
    public abstract boolean addProduct(AdminAccount admin, Product prod);
    public abstract boolean removeProduct(AdminAccount admin, Product prod);
    public abstract boolean setPriceProduct(AdminAccount admin, Product prod);

    
}
