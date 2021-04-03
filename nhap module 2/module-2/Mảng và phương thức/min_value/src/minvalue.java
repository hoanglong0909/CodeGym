import java.util.Scanner;

public class minvalue {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(" Nhập size");
        int size = scanner.nextInt();

        int[] array1 = array(size);

        System.out.println("mang là: ");
        for (int i:array1) {

            System.out.print(i +" " );
        }


        System.out.println(" ");
//        int i = minArray(array1);
        System.out.println(" so nho nhat la: " + minArray(array1));
    }


    public static int[] array( int size){
        int[] array = new int[size];
        for(int i = 0 ;i<array.length;i++){
            array[i] = (int)Math.round(Math.random()*101);

        }return array;
    }


    public static int minArray(int[] array){
        int min = array[0];
        for(int i = 1 ;i<array.length;i++){
            if(min>array[i]){
                min = array[i];
            }
        }return min;
    }

}
