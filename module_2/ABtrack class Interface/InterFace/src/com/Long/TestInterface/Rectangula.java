package com.Long.TestInterface;

public class Rectangula extends Rectangle implements VolumeShape{
    private  double height;
    public Rectangula(){}

    public Rectangula(double width, double length, double height) {
        super(width, length);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getVolume() {
        return getArea() *2;
    }

    @Override
    public void display() {
        System.out.println("Đây là rectanggula :  ");
        super.display();
        System.out.println("Volume Rectangula" + getVolume());
    }
}
