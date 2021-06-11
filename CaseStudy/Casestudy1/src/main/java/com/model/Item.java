package com.model;

public class Item {
    private int id;
    private Electronic electronic;
    private Float price;
    private int quantity;


    public Item(int id, Electronic electronic, Float price, int quantity, float total) {
        this.id = id;
        this.electronic = electronic;
        this.price = price;
        this.quantity = quantity;
    }

    public Item(int id, Electronic electronic, Float price, int quantity) {
        this.id = id;
        this.electronic = electronic;
        this.price = price;
        this.quantity = quantity;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Electronic getElectronic() {
        return electronic;
    }

    public void setElectronic(Electronic electronic) {
        this.electronic = electronic;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
