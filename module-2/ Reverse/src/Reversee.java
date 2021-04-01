import java.util.Scanner;

public class Reversee {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a size: ");
        size = scanner.nextInt();
        while (size > 20){
            System.out.println("do not size: ");
            break;
        }
        array = new int[size];
        int i= 0 ;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;

            System.out.printf("%-20s%s", "Elements in array: ", "");
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + "\t");

            }
            for (int j = 0; j < array.length / 2; j++) {
                int temp = array[j];
                array[j] = array[size - 1 - j];
                array[size - 1 - j] = temp;


            }
            System.out.printf("%-20s%s", "Reverse array: ", "");
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + "\t");
            }
        }

    }


}
