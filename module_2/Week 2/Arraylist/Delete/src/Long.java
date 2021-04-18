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

        int[] arr3 = new int[n+m];

        for(int i = 0 ; i < arr.length ; i++){
            arr3[i] = arr[i];
        }
        for(int i = 0 ; i < arr2.length; i++){
            arr3[arr.length+i]= arr2[i];
        }

        int temp;
        for(int i = 0 ; i < arr3.length - 1 ; i ++){
            for(int j = i +1 ; j < arr3.length ; j ++){
                if(arr3[i] >  arr3[j]){
                    temp = arr3[i];
                    arr3[i] = arr3[j];
                    arr3[j] = temp ;
                }
            }
        }
        for(int x : arr3){
            System.out.print(x + " ");
        }

    }
}