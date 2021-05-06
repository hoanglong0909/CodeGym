package com.contact.model;

public class Contact {
    private String name;
    private String age;
    private String dob;
    private String address;
    private String phone;
    private String email;
    private String oder;
    public void Contact(){
    }

    public Contact(String name, String age, String dob, String address, String phone, String email, String oder) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.oder = oder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getOder() {
        return oder;
    }

    public void setOder(String oder) {
        this.oder = oder;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", dob='" + dob + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", oder='" + oder + '\'' +
                '}' +"\n";
    }
    public String toStringCSV() {
        return name +","+ age +","+ dob +","+ address +","+ phone +","+ email+","+oder +"\n";
    }
}
