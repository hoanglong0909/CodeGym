import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        for (int i = 1;; i++) {
            if (isPrime(i)) {
                System.out.println(i);
                count += 1 ;
            }
            if (count == 20) {
                break;
            }
        }
    }

    public static boolean isPrime(int number){
        if(number<2)
            return false;
        else {
            for(int i =2 ; i<number;i++){
                if(number%i==0){
                    return false;
                }
            }
            return true;
        }
    }
}

