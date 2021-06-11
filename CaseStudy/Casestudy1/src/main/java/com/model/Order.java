package com.model;

import java.util.List;

public class Order {
    private int id ;
    private List<Item> items ;
    private int status;
    private float total;

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Order() {
    }

    public Order(int id, List<Item> items, int status) {
        this.id = id;
        this.items = items;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
