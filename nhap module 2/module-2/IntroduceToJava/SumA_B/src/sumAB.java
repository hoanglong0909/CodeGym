import java.util.Scanner;

public class sumAB {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(" Nhap số 1 ");
        int so1 = input.nextInt();
        System.out.println(" Nhap số 2 ");
        int so2 = input.nextInt();
        int result = so1 + so2 ;
        System.out.println("số thứ 1: " + so1);
        System.out.println("số thứ 2: "+ so2);
        System.out.println("------------");
        System.out.println("total 2 số : " + result);
    }
}
