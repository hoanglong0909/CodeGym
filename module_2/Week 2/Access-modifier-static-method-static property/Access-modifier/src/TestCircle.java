import java.util.Scanner;

public class TestCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" nhập bán kính: ");
        double radius = scanner.nextDouble();
        AccessModifier circle = new AccessModifier(radius);
//        circle.setRadius(radius);
        System.out.println("S là :" + circle.getArea());

    }
}
