package com.niit.course13Sprint4.model;

public class Address {
    private int pin;
    private String street;
    private String city;

    public Address() {
    }

    public Address(int pin, String street, String city) {
        this.pin = pin;
        this.street = street;
        this.city = city;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "pin=" + pin +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
