package org.example.domain;

import java.util.List;

public class Customer {
    private int custId;
    private String custName;
    private double custBill;
    private List<Item> itemList;

    public Customer() {
    }

    public Customer(int custId, String custName, double custBill, List<Item> itemList) {
        this.custId = custId;
        this.custName = custName;
        this.custBill = custBill;
        this.itemList = itemList;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public double getCustBill() {
        return custBill;
    }

    public void setCustBill(double custBill) {
        this.custBill = custBill;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custBill=" + custBill +
                ", itemList=" + itemList +
                '}';
    }
}
