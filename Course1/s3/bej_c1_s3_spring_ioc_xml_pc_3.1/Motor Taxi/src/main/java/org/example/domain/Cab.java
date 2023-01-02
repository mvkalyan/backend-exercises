package org.example.domain;

import java.util.List;

public class Cab {
    private int cabNo;
    private String cabName;
    private double cabBasePrice;
    private List<Commuter> commuters;

    public Cab() {
    }

    public Cab(int cabNo, String cabName, double cabBasePrice, List<Commuter> commuters) {
        this.cabNo = cabNo;
        this.cabName = cabName;
        this.cabBasePrice = cabBasePrice;
        this.commuters = commuters;
    }

    public int getCabNo() {
        return cabNo;
    }

    public void setCabNo(int cabNo) {
        this.cabNo = cabNo;
    }

    public String getCabName() {
        return cabName;
    }

    public void setCabName(String cabName) {
        this.cabName = cabName;
    }

    public double getCabBasePrice() {
        return cabBasePrice;
    }

    public void setCabBasePrice(double cabBasePrice) {
        this.cabBasePrice = cabBasePrice;
    }

    public List<Commuter> getCommuters() {
        return commuters;
    }

    public void setCommuters(List<Commuter> commuters) {
        this.commuters = commuters;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "cabNo=" + cabNo +
                ", cabName='" + cabName + '\'' +
                ", cabBasePrice=" + cabBasePrice +
                ", commuters=" + commuters +
                '}';
    }
}
