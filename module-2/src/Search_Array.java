import java.util.Scanner;

public class newarr {
    public static void main(String[] args) {
        int[] array;
        int size;
        int x ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("input number search");
        x = scanner.nextInt();
        System.out.println("ingput arr.length");
        size = scanner.nextInt();
        array = new int[size];
        System.out.println("mảng dược tạo");
        for (int i = 0; i < size; i++) {
            array[i] = (int) Math.round(Math.random() * 5);
            System.out.print(array[i] + "\t");
        }
        int post = searchele(array, x);
        if (post == -1) {
            System.out.println("không tìm thấy number");
        } else {
            System.out.println("số được tìm là " + x + "ở vị trí" + post);
        }

    }
    static int searchele(int[] array, int x){
        for(int i = 0 ; i< array.length;i++){
            if(array[i] == x){
                return  i ;
            }
        }return -1;
    }

}