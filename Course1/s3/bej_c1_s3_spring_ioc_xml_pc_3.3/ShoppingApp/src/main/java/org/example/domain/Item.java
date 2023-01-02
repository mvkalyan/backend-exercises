package org.example.domain;

public class Item {
    private int itemId;
    private double itemPrice;
    private String itemCat;

    public Item() {
    }

    public Item(int itemId, double itemPrice, String itemCat) {
        this.itemId = itemId;
        this.itemPrice = itemPrice;
        this.itemCat = itemCat;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemCat() {
        return itemCat;
    }

    public void setItemCat(String itemCat) {
        this.itemCat = itemCat;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemPrice=" + itemPrice +
                ", itemCat='" + itemCat + '\'' +
                '}';
    }
}
