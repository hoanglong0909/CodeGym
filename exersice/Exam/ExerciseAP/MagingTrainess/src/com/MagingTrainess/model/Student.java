package com.MagingTrainess.model;

import java.util.ArrayList;

public class Student {
    public static int count;
    public int id;
    public String name;
    public String gender;
    public String dob;

    public Student() {
    }


    public Student( String name , String dob, String gender) {
        this.id = ++count;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        initPointFactor1();
        initPointFactor2();
        initPointFactor3();
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Student.count = count;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    private ArrayList<ArrayList<Double>> poins = new ArrayList<>();
    private ArrayList<Double>poinFactor1 = new ArrayList<>();
    private ArrayList<Double>poinFactor2 = new ArrayList<>();
    private ArrayList<Double>poinFactor3 = new ArrayList<>();
    private double averagePoint = -1 ;

    public void initPointFactor1(){
        poins.add(poinFactor1);
        double poin1 = -1 ;
        double poin2 = -1 ;
        poinFactor1.add(poin1);
        poinFactor1.add(poin2);
    }
    public void initPointFactor2(){
        poins.add(poinFactor2);
        double poin1 = -1 ;
        poinFactor2.add(poin1);
    }
    public void initPointFactor3(){
        poins.add(poinFactor3);
        double poin1 = -1;
        poinFactor3.add(poin1);
    }

    public ArrayList<ArrayList<Double>> getPoins() {
        return poins;
    }

    public void setPoins(ArrayList<ArrayList<Double>> poins) {
        this.poins = poins;
    }

    public ArrayList<Double> getPoinFactor1() {
        return poinFactor1;
    }

    public void setPoinFactor1(ArrayList<Double> poinFactor1) {
        this.poinFactor1 = poinFactor1;
    }

    public ArrayList<Double> getPoinFactor2() {
        return poinFactor2;
    }

    public void setPoinFactor2(ArrayList<Double> poinFactor2) {
        this.poinFactor2 = poinFactor2;
    }

    public ArrayList<Double> getPoinFactor3() {
        return poinFactor3;
    }

    public void setPoinFactor3(ArrayList<Double> poinFactor3) {
        this.poinFactor3 = poinFactor3;
    }

    public double getAveragePoint() {
        return averagePoint;
    }

    public void setAveragePoint(double averagePoint) {
        this.averagePoint = averagePoint;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", poins=" + poins +
                ", poinFactor1=" + poinFactor1 +
                ", poinFactor2=" + poinFactor2 +
                ", poinFactor3=" + poinFactor3 +
                ", averagePoint=" + averagePoint +
                '}';
    }
}
