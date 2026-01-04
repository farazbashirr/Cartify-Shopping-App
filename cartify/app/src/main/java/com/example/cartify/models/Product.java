package com.example.cartify.models;

public class Product {
    private String brand;
    private String name;
    private double price;
    private double oldPrice;
    private int discount;
    private int quantity = 1;

    public Product(String brand, String name, double price, double oldPrice, int discount) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.oldPrice = oldPrice;
        this.discount = discount;
    }

    public String getBrand() { return brand; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getOldPrice() { return oldPrice; }
    public int getDiscount() { return discount; }
    public int getQuantity() { return quantity; } public void setQuantity(int quantity) { this.quantity = quantity; }
}
