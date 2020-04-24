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
public class Food extends Product{
    private String foodName;
    private int price;

    public Food(int productId, String foodName, int price) {
        super(productId);
        this.foodName = foodName;
        this.price = price;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        StringBuilder foodString = new StringBuilder();
        foodString.append(super.toString());
        foodString.append("Food{" + foodName +", "+ price +" Bath }");
        return foodString.toString();
    }
}
