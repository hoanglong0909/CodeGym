package com.manager.model;

public class Student {
    public int id;
    public String name;
    public String gender;
    public String email;
    public String phone;
    public int age;

    public Student() {
    }

    public Student(String name, String gender, String email, String phone, int age) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public Student(int id, String name, String gender, String email, String phone, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.age = age;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
