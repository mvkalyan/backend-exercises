package org.example.domain;

public class Cab {
    private String cabNo;
    private String cabCompany;
    private double cabPrice;

    public Cab() {
    }

    public Cab(String cabNo, String cabCompany, double cabPrice) {
        this.cabNo = cabNo;
        this.cabCompany = cabCompany;
        this.cabPrice = cabPrice;
    }

    public String getCabNo() {
        return cabNo;
    }

    public void setCabNo(String cabNo) {
        this.cabNo = cabNo;
    }

    public String getCabCompany() {
        return cabCompany;
    }

    public void setCabCompany(String cabCompany) {
        this.cabCompany = cabCompany;
    }

    public double getCabPrice() {
        return cabPrice;
    }

    public void setCabPrice(double cabPrice) {
        this.cabPrice = cabPrice;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "cabNo='" + cabNo + '\'' +
                ", cabCompany='" + cabCompany + '\'' +
                ", cabPrice=" + cabPrice +
                '}';
    }
}
