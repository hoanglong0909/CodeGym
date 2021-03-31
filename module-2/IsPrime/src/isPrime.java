import java.util.Scanner;

public class isPrime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("nhap vào number ");
        int number = input.nextInt();
        if(number < 2)
            System.out.print("is not isPrime");
        else{
            int i = 2 ;
            boolean check = true;
            while (i <= Math.sqrt(number)){
                if(number % i ==0){
                    check = false;
                    break;
                }
                i++;
            }
            if (check)
            System.out.println(number + "is a Prime");
            else
                System.out.println(number + "is not Prime");

        }
        }
}
