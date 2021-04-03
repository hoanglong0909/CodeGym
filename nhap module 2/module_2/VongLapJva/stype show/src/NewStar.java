import java.util.Scanner;

public class NewStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("draw a triangle 1 ");
        System.out.println("draw a rectangle 2 ");
        System.out.println("draw a square 3 ");
        System.out.println("draw a triang 5");
        System.out.println("exit  5");
        System.out.println("enter a number : ");
        int choise = sc.nextInt();
        switch (choise) {
            case 1: {
                System.out.println("width: ");
                int width = sc.nextInt();
                System.out.println("draw a triangle");

                for (int i = 1; i <= width; i++) {
                    System.out.println(" ");
                    for (int j = 1; j <= i; j++)
                        System.out.print("*");
                }
                System.out.println(" ");
                System.out.println("septempt 1");
                for(int i = width ; i>0 ;i--){
                    System.out.println(" ");
                    for(int j = i ; j>0 ;j--)
                        System.out.print("*");
                }
                break;
            }
            case 2:{
                System.out.println("width: ");
                int width = sc.nextInt();
                System.out.println("height: ");
                int height = sc.nextInt();
                System.out.println("draw a rectangle");
                for(int i = 1;i <= height;i++ ){
                    for (int j =1 ;j<= width;j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;

            }
            case 3:{
                System.out.println("width: ");
                int width = sc.nextInt();

                System.out.println("draw a square");
                for(int i = 1;i<= width;i++){
                    for (int j = 1;j <= width;j--){
                        System.out.print("*");
                    }
                    System.out.println();
                }break;
            }
            case 4:{
                System.out.println("width: ");
                int width = sc.nextInt();
                for(int i = 1; i <= width;i++) {
                    System.out.println();
                    for (int j = width; j > i; j--) {
                        System.out.print(" ");
                    }
                    for (int k = 1; k <= i; k++) {
                        System.out.print(" *");
                    }
                }
                System.out.println("hello");

                    for (int i = 1; i <= width; i++) {
                        System.out.println();
                        for (int j = 1; j <= i; j++) {
                            System.out.print(" ");
                        }
                        for (int k = width; k >= i; k--) {
                            System.out.print("* ");
                        }
                    }


                break;
                    }



            case 5:
                System.exit(0);
            default:
                System.out.println("no choise");
        }

    }
}
