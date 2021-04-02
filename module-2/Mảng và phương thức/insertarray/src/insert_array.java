import java.util.Scanner;

public class insert_array {
    public static void main(String[] args) {
        int size;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập size : ");
        size = sc.nextInt();
        int[] arr = new int[size+1];
        createArray(arr);
        outputArray(arr);
        insertEle(12,3,arr);
    }
    public static int[] createArray(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            arr[i]=(int)(Math.random()*9+1);
        }
        return arr;
    }
    public static void outputArray(int[] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.printf("pt thứ %d là %d \n",i,arr[i]);
        }
    }
    public static void insertEle(int ele,int index,int[] arr){
        for (int i=arr.length-1;i>=index;i--){
            if(i!=index){
                arr[i] = arr[i-1];
            }
            else{
                arr[i] = ele;
            }
        }
        System.out.println("MẢng sau khi thêm : ");
        outputArray(arr);
    }
}
