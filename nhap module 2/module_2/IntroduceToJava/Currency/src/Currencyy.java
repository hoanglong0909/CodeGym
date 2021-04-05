import java.util.Scanner;

public class Currencyy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap pt bac 2 ax+bx+c = 0");
        System.out.println("nhập vào a");
        double a = scanner.nextDouble();
        System.out.println("nhập vào b");
        double b = scanner.nextDouble();
        System.out.println("nhập vào c");
        double c = scanner.nextDouble();
        if(a==0){
            if(b==0){
                if(c==0){
                    System.out.println("phương trình vô số nghiệm");
                }else {
                    System.out.println(" Phương trình vô nghiệm");
                }

            }else {
                double x = -b/a ;
                System.out.println("pt có một nghiệm x = "+ (x));
            }

        }else{
            double delta = b*b - 4*a*c ;
            if(delta<0){
                System.out.println("phương trình vô nghiệm");
            }else if(delta==0){
                double x1 = -b/(2*a);
                System.out.println("phương trình có một nghiệm duy nhất x1"+ x1);
            }else {
                double x2 = (-b + Math.sqrt(delta)) / (2 * a);
                double x3 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("phương trình có hai nghiệm kép x1=" + x2 +"và x2 = " +x3);
            }
        }


    }
}

