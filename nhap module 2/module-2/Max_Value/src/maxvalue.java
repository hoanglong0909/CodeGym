import java.util.Scanner;

public class maxvalue {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        System.out.println("input number");
        size = scanner.nextInt();
        for(int i =0;i<size;i++){
            if (size > 20) {
                System.out.println("not number");
                size = scanner.nextInt();
            }
        }
        array = new int[size];
        System.out.printf("  mang mới là ");
        for(int j = 0;j<array.length;j++){

            array[j] = (int)Math.round(Math.random()*101);
            System.out.print(array[j] +"\t");
        }
        int max = array[0];
        int index = 0;
        for(int j = 0 ; j<array.length;j++){
            if(max<array[j]){
                max = array[j];
                index = j;
            }

        }
        System.out.println("giá trị lớn nhất " + max+" vị ví là"+ (index));



    }
}
