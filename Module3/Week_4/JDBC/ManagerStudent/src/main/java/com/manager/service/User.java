package com.manager.service;

public class User {
    private  int id;
    private  String userName;
    private String passWord;

    public User() {
    }

    public User(int id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return passWord;
    }

    public void setPassword(String password) {
        this.passWord = passWord;
    }
}
