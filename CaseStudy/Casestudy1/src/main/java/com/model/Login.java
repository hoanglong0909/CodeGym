package com.model;

public class Login {
    private int id;
    private String userName;
    private String pasWord;
    private String email;
    private int isSell;
    private int isAdmin;

    public Login() {
    }

    public Login(int id, String userName, String pasWord, String email, int isSell, int isAdmin) {
        this.id = id;
        this.userName = userName;
        this.pasWord = pasWord;
        this.email = email;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
    }

    public Login(int id, String userNames, String passWords) {
        this.id = id;
        this.userName = userName;
        this.pasWord = pasWord;
    }
    public Login( String userName, String pasWord, String email) {
        this.userName = userName;
        this.pasWord = pasWord;
        this.email = email;

    }

    public Login(int id, String userNames) {
        this.id = id;
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
