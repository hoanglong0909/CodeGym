
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;
public class moreArray {
    public static void main(String[] args) {
        int size1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập size");
        size1 = scanner.nextInt();
        int[] array = createArray(size1);
        System.out.println("nhập value : ");
        int value = scanner.nextInt();

        int check = insertAray(value,array);
        if(check == -1){
            System.out.println("không có trong mảng");
        }else {
            System.out.println(" number ở  " +( check + 1));
            int[] arrays = DeleteArray(check,array);
            System.out.println("mảng sau khi xóa" + Arrays.toString(arrays));
        }



    }
    static int[] createArray(int size){
        int[] array;
        array = new int[size];
        System.out.println("mảng Aray: ");
        for (int i = 0; i < size; i++){
            array[i] = (int) (Math.random() * 10 + 1);
            System.out.print((array[i] + "\t"));
        }
        return array;
    }
    public static int insertAray(int x,int[] array) {
        for (int i = 0 ; i< array.length;i++){
            if(array[i] == x)
                return i;
        }return -1;

    }
    public static int[] DeleteArray(int index,int[] array){
        for (int i = index ; i< array.length-1;i++){
            array[i]=array[i+1];

        } array[array.length-1] = 0 ;
        return array ;


    }



}








