import java.util.Scanner;

public class InsertArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" nhập size");
        int size = scanner.nextInt();
        System.out.println(" tạo mảng : ");
        int[] array = moreArray.createArray(size);
        System.out.println("nhập giá trị");
        int value = scanner.nextInt();
        System.out.println("nhập vị trí index");
        int index = scanner.nextInt();
        System.out.println("mảng trả về");
        int[] arr = moreArray(array,value,index);
        for (int i : arr) {
            System.out.print( + i);
        }
    }
    public static int[] moreArray(int[] array, int value, int index) {
        System.out.println();
        int arraySize =array.length-1 ;
        int[] arr = new int[array.length+1];
        for( int i = arr.length -1;i>= 0 ; i-- ){
            if(i != index-1 ){
                arr[i] = array[arraySize --] ;
            }else {
                arr[i]= value ;
            }
        }
return arr ;
    }
}