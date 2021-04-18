import java.util.ArrayList;
import java.util.Scanner;
public class Atm {
    private String name;
    private int accountBalance;
    // History:
    private ArrayList<String> history = new ArrayList<String>();

    public Atm(String name, int accountBalance) {
        this.name = name;
        this.accountBalance = accountBalance;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }
    Scanner sc = new Scanner(System.in);
    public void Menu(){
        System.out.println("Menu:");
        System.out.println("\t1. Nhan phim A de kiem tra tai khoan");
        System.out.println("\t2. Nhan phim D de nap tien");
        System.out.println("\t3. Nhan phim W de rut tien");
        System.out.println("\t4. Nhan phim H de xem lich su 3 lan");
        System.out.println("\t5. Nhan phim X de thoat");
        System.out.println("===========================================");
        System.out.println("Nhap lua chon cua ban: ");
    }
    public void importA(){
        System.out.println("So du tai khoan khach hang la: 1200000 vnd");
        System.out.println("Bam nut theo menu de tiep tuc giao dich");
        System.out.println("===========================================");
    }
    public void importD(){
        System.out.println("Giao dich Nap tien");
        System.out.println("Vui long nhap so tien:");
        int recharge = sc.nextInt();
        System.out.println("Giao dich thanh cong. Ban vua nap " + recharge + " thanh cong.");
        setAccountBalance(accountBalance + recharge);
        history.add("Nap tien: " + recharge );
        System.out.println("So du tai khoan khach hang la: " + accountBalance + " vnd ");
        System.out.println(" ");
        System.out.println("Bam nut theo menu de tiep tuc giao dich");
        System.out.println("===========================================");
        System.out.println(" ");

    }

    public void importW(){
        System.out.println("Giao dich Rut tien:");
        System.out.println("Vui long nhap so tien:");
        int withdrawal = sc.nextInt();
        int total = getAccountBalance() - withdrawal;
        if(getAccountBalance() > withdrawal) {
            System.out.println("Giao dich thanh cong. Ban vua rut " + withdrawal +" thanh cong.");
            System.out.println("So du tai khoan khach hang la: " + total + " vnd ");
            setAccountBalance(total);
            history.add("Rut tien " + withdrawal );
            System.out.println("Bam nut theo menu de tiep tuc giao dich");
            System.out.println("===========================================");
        } else {
            System.out.println("Giao dich khong thanh cong.");
            System.out.println("So du tai khoan khach hang la: " + getAccountBalance() + " Vnd. ");
            System.out.println("Ban khong the rut so tien hon so du tai khoan");
            System.out.println("Bam nut theo menu de tiep tuc giao dich");
            System.out.println("===========================================");
        }

    }
    public void importH() {

        System.out.println("Lịch Sử Giao Dịch: ");
        if (history.size() == 0) {
            System.out.print(" Hiện Tại Hệ Thống Chưa Nhận Giao Dịch \n");
        }
        if (history.size() > 3) {
            int j = 1;
            for (int i = history.size()-3  ; i < history.size(); i++) {
                System.out.println((j++) + ". " + history.get(i));
            }
        } else {
            for (int i = 0 ; i < history.size(); i++) {
                System.out.println(i+ 1 + ". " + history.get(i));
            }
        }
    }
    public void login(){
        while (true) {
            System.out.println("Ngan hang ABC kinh chao quy khach " + name);
            Menu();
            String choice = sc.next();
            switch (choice) {
                case "A": {
                    importA();
                }
                break;
                case "D": {
                    importD();
                }
                break;
                case "W": {
                    importW();
                }
                break;
                case "H":{
                    importH();
                }
                break;
                case "X":{
                    System.out.println("CẢm ơn quý khách đã sử dụng dịch vụ");
                    System.exit(0);
                }
                default:

                    System.out.println("Ban nhap sai chuc nang");
                    System.out.println("Bam nut theo menu de tiep tuc giao dich");
                    System.out.println("===========================================");
            }
        }
    }
}