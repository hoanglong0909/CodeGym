import java.util.Scanner;

public class snt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 100; i++) {
            if (isprime(i))
                System.out.println(i);
        }
    }

    public static boolean isprime(int number) {
        if (number < 2) {
            return false;
        } else {
            for (int i = 0; i < number; i++) {
                if (number % 2 == 0) {
                    return false;
                }
            }return true;
        }
    }
}
