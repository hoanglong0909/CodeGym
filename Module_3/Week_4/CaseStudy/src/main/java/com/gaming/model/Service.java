package com.gaming.model;

public class Service{
    private int idProduct;
    private  String nameProduct;
    private float  priceProduct;
    private int accountProduct;
    private float accountTime;
    private float priceTime;


    public Service( int idProduct, String nameProduct, float priceProduct, int accountProduct, float accountTime, float priceTime) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.accountProduct = accountProduct;
        this.accountTime = accountTime;
        this.priceTime = priceTime;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public float getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(float priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getAccountProduct() {
        return accountProduct;
    }

    public void setAccountProduct(int accountProduct) {
        this.accountProduct = accountProduct;
    }

    public float getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(float accountTime) {
        this.accountTime = accountTime;
    }

    public float getPriceTime() {
        return priceTime;
    }

    public void setPriceTime(float priceTime) {
        this.priceTime = priceTime;
    }
}

