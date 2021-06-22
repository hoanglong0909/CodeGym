package com.gaming.model;

public class Client {
    private int idClient;
    private String nameClient;
    private String machineStatus;
    private String nameProduct;
    private int accountProduct;
    private int accountTime;
    private float totalMoney;


    public Client(String nameClient) {
    }

    public Client(int idClient, String nameClient, String machineStatus, String nameProduct, int accountProduct, int accountTime, float totalMoney) {
        this.idClient = idClient;
        this.nameClient = nameClient;
        this.machineStatus = machineStatus;
        this.nameProduct = nameProduct;
        this.accountProduct = accountProduct;
        this.accountTime = accountTime;
        this.totalMoney = totalMoney;
    }

    public Client(int idClient, String nameClient, String machineStatus) {
        this.idClient = idClient;
        this.nameClient = nameClient;
        this.machineStatus = machineStatus;
    }

    public Client(int idClient, String nameClient) {
        this.idClient = idClient;
        this.nameClient = nameClient;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getAccountProduct() {
        return accountProduct;
    }

    public void setAccountProduct(int accountProduct) {
        this.accountProduct = accountProduct;
    }

    public int getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(int accountTime) {
        this.accountTime = accountTime;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getMachineStatus() {
        return machineStatus;
    }

    public void setMachineStatus(String machineStatus) {
        this.machineStatus = machineStatus;
    }
}
