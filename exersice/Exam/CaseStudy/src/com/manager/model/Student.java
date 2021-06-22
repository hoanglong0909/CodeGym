package com.manager.model;

import java.util.ArrayList;

public class Student implements Comparable<Student>{
    public static int count;
    public int id;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private String dob;

    public Student() {
    }

    public Student(String name,String gender, String dob) {
        this.id = ++count;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        initPointFactor1();
        initPointFactor2();
        initPointFactor3();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static void setAutoId(int count) {
        Student.count = count ;
    }

    public static int getAutoId() {
        return count;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private ArrayList<ArrayList<Double>> points = new ArrayList<>();
    private ArrayList<Double> pointFactor1 = new ArrayList<>();
    private ArrayList<Double> pointFactor2 = new ArrayList<>();
    private ArrayList<Double> pointFactor3 = new ArrayList<>();

    private double averagePoint = -1;

    private void initPointFactor1() {
        points.add(pointFactor1);
        double point1 = -1;
        double point2 = -1;
        pointFactor1.add(point1);
        pointFactor1.add(point2);
    }

    private void initPointFactor2() {
        points.add(pointFactor2);
        double point1 = -1;
        pointFactor2.add(point1);
    }

    private void initPointFactor3() {
        points.add(pointFactor3);
        double point1 = -1;
        pointFactor3.add(point1);
    }

    public ArrayList<ArrayList<Double>> getPoints() {
        return points;
    }

    public ArrayList<Double> getPointFactor1() {
        return pointFactor1;
    }

    public ArrayList<Double> getPointFactor2() {
        return pointFactor2;
    }

    public ArrayList<Double> getPointFactor3() {
        return pointFactor3;
    }

    public double getAveragePoint() {
        return averagePoint;
    }

    public void setAveragePoint() {
        double totalPointFactor1 = 0;
        double totalPointFactor2 = 0;
        double totalPointFactor3 = 0;
        int countNegativePointFactor1 = 0;
        int countNegativePointFactor2 = 0;
        int countNegativePointFactor3 = 0;
        for (Double point : pointFactor1) {
            if (point < 0) {
                totalPointFactor1 += 0;
                countNegativePointFactor1++;
            } else
                totalPointFactor1 += point;
        }
        for (Double point : pointFactor2) {
            if (point < 0) {
                totalPointFactor2 += 0;
                countNegativePointFactor2++;
            } else
                totalPointFactor2 += point * 2;
        }
        for (Double point : pointFactor3) {
            if (point < 0) {
                totalPointFactor3 += 0;
                countNegativePointFactor3++;
            } else
                totalPointFactor3 += point * 3;
        }
        double totalNumberOfPoints = (pointFactor1.size() - countNegativePointFactor1) + ((pointFactor2.size() - countNegativePointFactor2) * 2) + ((pointFactor3.size() - countNegativePointFactor3) * 3);
        averagePoint = (totalPointFactor1 + totalPointFactor2 + totalPointFactor3) / totalNumberOfPoints;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", points=" + points +
                ", pointFactor1=" + pointFactor1 +
                ", pointFactor2=" + pointFactor2 +
                ", pointFactor3=" + pointFactor3 +
                ", averagePoint=" + averagePoint +
                '}';
    }

    public String toStringCSV(){
        return name + "," + gender+ "," +dob+ "," +pointFactor1+ "," +pointFactor2+ "," +pointFactor3 + "\n";

    }
    @Override
    public int compareTo(Student o) {
        if (o.getAveragePoint() > this.getAveragePoint()) {
            return 1;
        } else if (o.getAveragePoint() == this.getAveragePoint()) {
            return 0;
        } else {
            return -1;
        }
    }
}
