import java.util.Scanner ;
public class Long{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i = 0; i < m ; i++){
            arr[i] = sc.nextInt();
        }

        int size = n+ m ;
        int[] arr3 = new int[size];

        for (int i=0; i<size;i++){
            if (i< arr.length){
                arr3[i] = arr[i];
            }
            else arr3[i] = arr2[i-arr.length];
        }
        int temp = 0;
        for(int i = 0 ; i < size ; i ++){
            for(int j = 0; j < size ; j ++){
                if(arr3[i]< arr3[j]){
                    temp = arr3[i];
                    arr3[i] = arr3[j];
                    arr3[j] = temp ;
                }
            }
        }
        for(int i : arr3){
            System.out.println(i);
        }

    }
}