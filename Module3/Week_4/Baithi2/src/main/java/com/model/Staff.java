package com.model;

public class Staff {
    private int id;
    private String groupStaff;
    private String fullName;
    private String gender;
    private String phoneNumber;
    private String dob;
    private String cmndNumber;
    private String email;

    public Staff() {
    }

    public Staff(int id, String groupStaff, String fullName, String gender, String phoneNumber, String dob, String cmndNumber, String email) {
        this.id = id;
        this.groupStaff = groupStaff;
        this.fullName = fullName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.cmndNumber = cmndNumber;
        this.email = email;
    }

    public Staff(String groupStaff, String fullName, String gender, String phoneNumber, String dob, String cmndNumber, String email) {
        this.groupStaff = groupStaff;
        this.fullName = fullName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.cmndNumber = cmndNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupStaff() {
        return groupStaff;
    }

    public void setGroupStaff(String groupStaff) {
        this.groupStaff = groupStaff;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCmndNumber() {
        return cmndNumber;
    }

    public void setCmndNumber(String cmndNumber) {
        this.cmndNumber = cmndNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
