import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String choose = null;
        boolean exit;
        ProductManager pro = new ProductManager();
        Scanner sc = new Scanner(System.in);
        pro.showMenu();
        while (true){
            choose = sc.nextLine();
            switch (choose){
                case "1":
                    pro.add();
                    break;
                case "2":
                    String productCode = sc.nextLine();
                    pro.edit(productCode);
                    break;
                case "3":
                    pro.show();
                    break;
                case "0":
                    System.out.println("Đã hoàn tất");
                    System.exit(0);
                    break;
            }
            pro.showMenu();
        }
    }
}