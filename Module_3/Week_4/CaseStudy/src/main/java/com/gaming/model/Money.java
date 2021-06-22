package com.gaming.model;

public class Money{
    private int idMoney;
    private float moneyTime;
    private float moneyProduct;
    private float totalMoney;


    public Money(int idMoney, float moneyTime, float moneyProduct, float totalMoney) {
        this.idMoney = idMoney;
        this.moneyTime = moneyTime;
        this.moneyProduct = moneyProduct;
        this.totalMoney = totalMoney;
    }

    public int getIdMoney() {
        return idMoney;
    }

    public void setIdMoney(int idMoney) {
        this.idMoney = idMoney;
    }

    public float getMoneyTime() {
        return moneyTime;
    }

    public void setMoneyTime(float moneyTime) {
        this.moneyTime = moneyTime;
    }

    public float getMoneyProduct() {
        return moneyProduct;
    }

    public void setMoneyProduct(float moneyProduct) {
        this.moneyProduct = moneyProduct;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = (moneyProduct+moneyTime);
    }
}
