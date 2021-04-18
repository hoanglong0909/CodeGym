package com.Long.TestInterface;

public class Cylinder extends Circle implements VolumeShape {
    private double heightCylinder ;

    public Cylinder() {
    }

    public Cylinder(double heightCylinder) {
        this.heightCylinder = heightCylinder;
    }

    public Cylinder(double radius, double heightCylinder) {
        super(radius);
        this.heightCylinder = heightCylinder;
    }
    public double getHeightCylinder() {
        return heightCylinder;
    }

    public void setHeightCylinder(double heightCylinder) {
        this.heightCylinder = heightCylinder;
    }
    @Override
    public double getVolume(){
        return getRadius()*getRadius()*heightCylinder*Math.PI;
    }

    @Override
    public void display() {
        System.out.println("Đây là Cylinder :  ");
        super.display();
        System.out.println("IVolume: " + getVolume());
    }
}
