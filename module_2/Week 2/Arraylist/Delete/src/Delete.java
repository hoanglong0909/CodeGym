import java.util.Scanner;
public class Delete{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] arr1 = new int[n-1];
        for(int i = 0 ; i< n-1; i++){
            if(i< k){
                arr1[i] = arr[i];
            }else{
                arr1[i] = arr[i+1];
            }
        }
        for(int i : arr1){
            System.out.print(i);
        }

    }
}
