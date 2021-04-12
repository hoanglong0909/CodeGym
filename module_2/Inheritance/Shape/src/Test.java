import static java.awt.Color.black;

public class Test {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Shape shape1 = new Shape("black",false);
        System.out.println(shape);
        System.out.println(shape1);
        Shape c = new Circle(10);
        System.out.println(c);
        Shape r = new Rectangle(12,10,"black",false) ;
        System.out.println(r);
    }
}
