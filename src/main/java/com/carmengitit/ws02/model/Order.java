package com.carmengitit.ws02.model;
import com.carmengitit.ws02.model.Product;
import com.carmengitit.ws02.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private HashMap<Product, Integer> products;
    private Customer customer;

    public Order() {
        products = new HashMap<Product, Integer>();
        customer = new Customer();
    }

    public Order(HashMap<Product, Integer> products, Customer customer){
        this.products = products;
        this.customer = customer;
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }

    public void addProduct(Product product, int quantity) {
        products.merge(product, quantity, (oldQty, newQty) -> oldQty + newQty);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotal() {
        double total = 0;
        for(Map.Entry<Product, Integer> item : products.entrySet()) {
            total += item.getKey().getPrice() * item.getValue();
        }
        return total;
    }
}
