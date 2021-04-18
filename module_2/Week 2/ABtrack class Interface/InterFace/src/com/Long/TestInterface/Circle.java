package com.Long.TestInterface;

public class Circle implements Shape {
    private double radius;
    public Circle(){}
    public Circle(double radius){
        this.radius = radius ;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius *radius*Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius ;
    }

    @Override
    public void display() {

        System.out.println("Đây là Cỉcle :  ");
        System.out.println("Area: " + getArea());
        System.out.println("Parimeter: " +getPerimeter());

    }

}
