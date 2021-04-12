package com.Long.TestInterface;

public class Rectangle implements Shape {
    private double width;
    private double length;

    public Rectangle(){}

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length ;
    }

    @Override
    public double getPerimeter() {
        return (width + length )*2 ;
    }

    @Override
    public void display() {
        System.out.println("Đây là rectangle :  ");
        System.out.println("Area: " + getArea());
        System.out.println("Parimeter: " +getPerimeter());
    }

}
