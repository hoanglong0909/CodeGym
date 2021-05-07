package com.exersice.model;

public class Contact {
    private String name;
    private String phone;
    private String group;
    private String gender;
    private String address;
    private String email;
    private String facebook;

    public Contact() {
    }

    public Contact(String name, String phone, String group, String gender, String address, String email, String facebook) {
        this.name = name;
        this.phone = phone;
        this.group = group;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.facebook = facebook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", group='" + group + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", facebook='" + facebook + '\'' +
                '}';
    }

    public String toStringCSV(){
        return name +","+phone +","+group +","+gender  +","+ address  + "," + email + ","+facebook+ "\n";
    }
}
