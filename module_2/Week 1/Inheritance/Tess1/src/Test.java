import java.util.Scanner;

public class Test {
    private  double radius;

    public Test(){5

    }

    public Test(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return getRadius()*getRadius()*Math.PI ;
    }

    public double getCircumference() {
        return 3.14 * 2 * radius;
    }
    public void getInformation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập bán kính : ");
        radius = scanner.nextDouble();
    }
    public void display(){
        System.out.println("bán kính là " + getRadius());
        System.out.println(" Area là " + getArea());
        System.out.println(" getCircumference là " + getCircumference());

    }
}
