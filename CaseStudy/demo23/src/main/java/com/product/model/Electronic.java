package com.product.model;

public class Electronic {
    private int id;
    private String name;
    private String image;
    private Float price;

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
