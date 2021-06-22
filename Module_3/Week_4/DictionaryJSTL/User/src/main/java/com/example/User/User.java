package com.example.User;

import java.util.Date;

public class User {
    private String username;
    private String password;
    private String fullName;
    private int age;
    private Date birthDate;
    private boolean gender;

    public User() {
    }

    public User(String username, String password, String fullName, int age, Date birthDate, boolean gender) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.age = age;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
