package com.product.model;

public class Electronic {
    private int id;
    private String name;
    private String image;
    private Float price;
    private int sell_id;
    private int category_id;

    public Electronic() {
    }

    public Electronic(int id, String name, String image, Float price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public Electronic(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Electronic(int id, int sell_id, String name, String image, Float price) {
        this.id = id;
        this.sell_id= sell_id;
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public Electronic(String name, String image, Float price, int categoryId) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.category_id = categoryId;
    }

    public Electronic(String name, String image, Float price, int category, int sell_id) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.category_id = category;
        this.sell_id = sell_id;

    }

    public Electronic(int id, String name, String image, Float price, int category, int sell_id) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.category_id = category;
        this.sell_id= sell_id;
    }

    public Electronic(int id, String name, String image, Float price, int category) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.category_id = category;
    }

    public int getSell_id() {
        return sell_id;
    }

    public void setSell_id(int sell_id) {
        this.sell_id = sell_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
