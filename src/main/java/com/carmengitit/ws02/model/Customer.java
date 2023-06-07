package com.carmengitit.ws02.model;
import com.carmengitit.ws02.model.Order;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String phone; // Integer data types are bad at holding phone numbers.
    private ArrayList<Order> orders;

    public Customer() {
        name = "";
        phone = "";
    }

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
