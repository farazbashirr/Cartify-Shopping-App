package com.example.cartify.models;

public class Order {
    private int id;
    private int userId;
    private String productName;
    private double price;
    private int quantity;
    private String orderDate; // store as string "2026-01-04"

    public Order() {
    }

    public Order(int userId, String productName, double price, int quantity, String orderDate) {
        this.userId = userId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    public Order(int id, int userId, String productName, double price, int quantity, String orderDate) {
        this.id = id;
        this.userId = userId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
