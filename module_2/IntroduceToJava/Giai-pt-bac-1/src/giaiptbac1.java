import java.util.Scanner;


public class giaiptbac1 {
    public static void main(String[] args) {
        System.out.println("linear Equation Resolver: ");
        System.out.println("Given a equation as 'a * x + b = 0', please enter constants: ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();
        System.out.print("c: ");
        double c = scanner.nextDouble();
        if (a != 0) {
            double solution = -b / a ;
            System.out.printf("the solution is: %f!",solution);


        }
        if (a != 0) {
            double answer = (c - b) / a;
            System.out.printf("Equation pass with x = %f\n", answer);
        }else{
            if (b==0){
                System.out.printf("the solution is all x!");

            }else {
                System.out.printf("No solution!");
            }
        }

    }
}