package com.customer.model;

public class Customer {
    public String name;
    public String address;
    public String phoneNumber;
    public String email;
    public String gender;
    public String order;


    public Customer(String name, String address, String phoneNumber, String email, String gender, String order) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Khách hàng: " + name +", "+ "Địa chỉ: " + address +", "+ "Số điện thoại: " +phoneNumber +", "+ "E mail: "+ email +", "+"Giớ tính: "+ gender + ", "+"Số đơn hàng: " +order + "\n" ;
//            return name + address + email + phoneNumber + gender + order +"\n";
    }
    public String toStringCSV(){
        return "Khach hang: " + this.name + ", Dia chi: <" + this.address + ">, Email<" + this.email + ">, Sdt: <" + this.phoneNumber + ">, Gioi tinh: <" + this.gender + ">\n";
    }
}
