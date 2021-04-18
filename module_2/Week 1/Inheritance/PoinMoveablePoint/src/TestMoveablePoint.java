
import java.util.Arrays;

public class TestMoveablePoint {
    public static void main(String[] args) {
        Point point = new Point(2, 3);
//        float[] arr = point.getXY();
        System.out.println("mảng 1 là " + Arrays.toString(point.getXY()));

        MoveablePoint moveablePoint = new MoveablePoint(4.4f, 3, 2, 1);
        System.out.println("mảng 2 là" + moveablePoint.toString());
        moveablePoint.setXY(4.5f,2.8f);

        System.out.println(" mảng 5 : " + moveablePoint.toString());

        System.out.println("mảng 6 " + moveablePoint.move());

        System.out.println(Arrays.toString(point.getXY()));
    }

}
