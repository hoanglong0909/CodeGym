    import java.util.Scanner;
    public class Delete{
        public static boolean isPrime(int n){
            if(n < 2 ){
                return false;
            }else{
                for(int i = 2 ; i < n ; i++)
                {
                    if(n%i == 0 ){
                        return false;
                    }
                }
                return true;
            }
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ;i++){
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                if (isPrime(arr[i])){
                    System.out.print(arr[i] + " ");
                }
            }
        }
    }