package com.Long.TestInterface;

public class TestShape {
    public static void main(String[] args) {
        Shape[] shapess = new Shape[4];
        shapess[0] = new Circle(4);
        shapess[1] = new Rectangle(2,4);
        shapess[2] = new Cylinder(3,2) ;
        shapess[3] = new Rectangula(4,1,1);
        for (Shape shape: shapess
             ) {
            System.out.println("____________________________________");
            shape.display();

        }

    }
}
