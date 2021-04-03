import java.util.Scanner;

public class interset {
    public static void main(String[] args) {

        double money = 1.0;
        int month = 1;
       double interset_rate = 1.0;
        Scanner  input = new Scanner(System.in);
        System.out.println("Nhập giá trị money: ");
        money = input.nextDouble();
        System.out.println("Nhập month");
        month = input.nextInt();
        System.out.println( "Nhập giá trị interset rate: ");
        interset_rate = input.nextDouble();
        double total_interset_money = 0 ;
        for (int i = 0 ; i < month ; i++){
            total_interset_money += money * (interset_rate/100)/12 * month;
        }
        System.out.println("tota_interset_money" + total_interset_money);


    }
}
