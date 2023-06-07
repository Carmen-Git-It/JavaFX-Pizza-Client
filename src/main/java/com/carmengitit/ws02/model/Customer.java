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
        orders = new ArrayList<>();
    }

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
        orders = new ArrayList<>();
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

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Customer)) {
            return false;
        }

        Customer c = (Customer) obj;
        return this.name.equals(c.name) && this.phone.equals(c.phone);
    }
}
