import java.util.Arrays;
import java.util.Scanner;

public class Banthu1 {
    public static void main(String[] args) {
        Banthu1 banthu1 = new Banthu1();
        int[] arr1 = {5, 6, 7, 3, 9};
        System.out.println("Moi nhap so can xoa: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Ket qua: ");
        System.out.println(Arrays.toString(banthu1.deleteElementArray(arr1, number)));
    }

    int checkExist(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (number == arr[i]) {
                return i;
            }
        }
        return -1;
    }


    int[] deleteElementArray(int[] arr, int number) {
        int[] arr1 = new int[arr.length - 1];  //length = 4
        int indexOf = checkExist(arr, number);
        if (indexOf != -1) {
            for (int i = 0; i < indexOf; i++) {
                arr1[i] = arr[i];
            }
            for (int i = indexOf; i < arr1.length; i++) {
                arr1[i] = arr[i + 1];
            }
            return arr1;
        } else {
            System.out.println("so nay khong nam trong mang");
            return null;
        }
    }
}


//    int[] generateArray(int size) {
//        int[] arr = new int[size];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) Math.round(Math.random() * 100) + 1;
//        }
//        return arr;
//    }