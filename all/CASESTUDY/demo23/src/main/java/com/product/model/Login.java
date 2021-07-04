package com.product.model;

public class Login {
    private int id;
    private String userName;
    private String pasWord;
    private int isSell;
    private int isAdmin;

    public Login() {
    }

    public Login(int id, String userName, String pasWord, int isSell, int isAdmin) {
        this.id = id;
        this.userName = userName;
        this.pasWord = pasWord;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
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

    public String getPasWord() {
        return pasWord;
    }

    public void setPasWord(String pasWord) {
        this.pasWord = pasWord;
    }

    public int getIsSell() {
        return isSell;
    }

    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}
