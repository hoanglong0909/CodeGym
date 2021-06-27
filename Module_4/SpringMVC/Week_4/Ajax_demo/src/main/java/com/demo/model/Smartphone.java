package com.demo.model;


import javax.persistence.*;
@Entity
@Table(name="smartphones")
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String producer;
    private String model;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Smartphone() {
    }

    public Smartphone(String producer, String model, Double price) {
        this.producer = producer;
        this.model = model;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Smartphone(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "id=" + id +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
