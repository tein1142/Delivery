/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

/**
 *
 * @author tanaw
 */
public class Beverage extends Product{
    private String bevName;
    private int price;

    public Beverage(int productId,String bevName, int price) {
        super(productId);
        this.bevName = bevName;
        this.price = price;
    }

    public String getBevName() {
        return bevName;
    }

    public int getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        StringBuilder foodString = new StringBuilder();
        foodString.append(super.toString());
        foodString.append("Beverage{" + bevName +", "+ price +" Bath}");
        return foodString.toString();
    }
}
