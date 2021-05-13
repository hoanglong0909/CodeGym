package com.contact.model;

public class Contact {
    private String name;
    private String phone;
    private String email;
    private String address;
    private String dob;

    public Contact() {
    }

    public Contact(String name, String phone, String email, String address, String dob) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
    public String toStringCSV() {
        return name +","+phone+","+email+","+address+","+dob +"\n";
    }
}
