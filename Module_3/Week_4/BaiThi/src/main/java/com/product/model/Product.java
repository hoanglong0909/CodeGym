package com.product.model;

public class Product {
    private  int id;
    private String productName;
    private float price;
    private int quantity;
    private String color;
    Category category;

    public Product(int id, String productName, float price, int quantity, String color) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product() {
    }


    public Product(int id, String productName, float price, int quantity, String color, Category category) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
    }

    public Product(int id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public Product(String productName, float price, int quantity, String color, Category category) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
