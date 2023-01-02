package org.niit.Domain;

public class Address {

    private int pincode;
    private String houseno;
    private String city;
    private String state;

    public Address(int pincode, String houseno, String city, String state) {
        this.pincode = pincode;
        this.houseno = houseno;
        this.city = city;
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getHouseno() {
        return houseno;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "pincode=" + pincode +
                ", houseno='" + houseno + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
