import java.util.Scanner;

public class Circle extends Geometric{


    private  double radius;
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(10);
        circle.printCircle();
        circle.setColor("black");
        circle.printCircle();
//        circle.getColor();
//        circle.getArea();
//        circle.getDiameter();

        }
    public Circle(){

    }


    public Circle(String color, String filled, double radius) {
        super(color, filled);
        this.radius = radius;

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return radius*radius*Math.PI ;
    }
    public double getPerimeter(){
        return  2*radius*Math.PI ;
    }
    public  double getDiameter(){
        return 2*radius ;
    }
    public void printCircle(){
        System.out.println("the " + getColor()+  " circle is created with the radius is " + radius + getArea() +getDiameter() +getPerimeter() );
    }
}
