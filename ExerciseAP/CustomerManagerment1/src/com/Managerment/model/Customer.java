package com.Managerment.model;

public class Customer {
    private String name;
    private int phone;
    private String email;
    private String gender;
    private String address;
    private int oder;

    public Customer() {
    }

    public Customer(String name, int phone, String email, String gender, String address, int oder) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.oder = oder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOder() {
        return oder;
    }

    public void setOder(int oder) {
        this.oder = oder;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", oder=" + oder +
                '}';
    }
    public String toStringCSV() {
        return  name +","+ phone +","+ email +","+ gender +","+ address +","+ oder +"\n";
    }
}
