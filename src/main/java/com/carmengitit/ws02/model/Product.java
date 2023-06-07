package com.carmengitit.ws02.model;

public class Product {
    private String size;
    private String type;
    private double price;

    public Product(){
        size = "";
        type = "";
        price = 0;
    }

    public Product(String size, String type, double price){
        this.size = size;
        this.type = type;
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Product)){
            return false;
        }

        Product p = (Product) obj;

        return this.size.equals(p.size) && this.type.equals(p.type) && this.price == p.price;
    }
}
