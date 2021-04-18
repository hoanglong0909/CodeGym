import java.util.Arrays;

public class TestPoin2DPoin3D {
    public static void main(String[] args) {

        Poin2D poin2D = new Poin2D(2,5);
        System.out.println(poin2D);
        float[] array = poin2D.getXY() ;
        System.out.println("mảng này là : " + Arrays.toString(array) );

        Poin3D poin3D = new Poin3D(6,2,3);
        System.out.println(poin3D);
        float[] array1 = poin3D.getXYZ();
        System.out.println("mảng này là : " + Arrays.toString(array1) );
    }
}
