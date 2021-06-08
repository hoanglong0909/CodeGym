package com.model;

public class Account {
    private  int id;
    private String userName;
    private String passWord;

    public Account() {
    }

    public Account(int id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }

    public Account(String username, String password) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
