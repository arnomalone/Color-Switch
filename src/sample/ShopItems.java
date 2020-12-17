package sample;

import java.io.Serializable;

public class ShopItems implements Serializable {
    private boolean sold;
    private int price;

    ShopItems(boolean sold, int price){
        this.sold = sold;
        this.price = price;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
