package com.customer.presentation;
import com.customer.model.Customer;
import com.customer.service.CustomerService;
import java.io.IOException;
import java.util.Currency;
import java.util.Scanner;

public class MainCustomer {
    public static void menu(CustomerService cus) throws IOException {
        Scanner sc = new Scanner(System.in);
        int y = 0;
        while(y != 7) {
            System.out.println("Chao mung ban den voi he thong quan ly khach hang\nBấm 1 để nhập khách hang\nBấm 2 để tim kiem khach hang\nBam 3 de in thong khach hang\nBam 4 de in toan bo danh sach khach hang\nBam 5 de tang so don hang cho khach\nBam 0 de thoat\n==========================================================");
            y = sc.nextInt();
            sc.nextLine();
            switch(y) {
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Found");
                    System.out.println("Chọn Menu để tiếp thục thực hiện ");
                    break;
                case 1:
                    System.out.println("Input Name:");
                    String name = sc.nextLine();
                    System.out.println("Input Adress:");
                    String address = sc.nextLine();
                    System.out.println("Input phone:");
                    String phone = sc.nextLine();
                    System.out.println("Input Email:");
                    String email = sc.nextLine();
                    System.out.println("Input Gender:");
                    String gender = sc.nextLine();
                    System.out.println("Input Number-Order:");
                    int orderNumber = sc.nextInt();
                    cus.add(new Customer(name, address, phone, email, gender, orderNumber));
                    System.out.println("Bạn đã thêm thành công khách hàng " + name + " vào danh sách. " );
                    System.out.println("Chọn Menu để tiếp thục thực hiện ");
                    System.out.println("==========================================");
                    break;
                case 2:
                    System.out.println("Input phone ");
                    phone = sc.nextLine();
                    cus.searchInfor(phone);
                    System.out.println("Chọn Menu để tiếp thục thực hiện ");
                    System.out.println("==========================================");
                    break;
                case 3:
                    System.out.println("Input phone");
                    phone = sc.nextLine();
                    cus.getInfor(phone);
                    System.out.println("Chọn Menu để tiếp thục thực hiện ");
                    System.out.println("==========================================");
                case 4:
                    cus.display();
                    System.out.println("Chọn Menu để tiếp thục thực hiện ");
                    System.out.println("==========================================");
                    break;
                case 5:
                    System.out.println("Input phone");
                    phone = sc.nextLine();
                    System.out.println("Input number order add : ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    cus.addNumberOrder(phone, n);
                    System.out.println("Chọn Menu để tiếp thục thực hiện ");
                    System.out.println("==========================================");
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Customer ct1 = new Customer("Khanh", "Hue", "0782222595", "phuockhanh1010@gmail.com", "Male", 5);
        Customer ct2 = new Customer("Duong", "Hue", "0905234289", "duongvat@gmail.com", "Male", 6);
        Customer ct3 = new Customer("Phong", "Hue", "0364334561", "phongpro113@gmail.com", "Male", 2);
        Customer ct4 = new Customer("Han", "Hue", "0356754546", "hanny@gmail.com", "Male", 4);
        Customer ct5 = new Customer("Thien", "Hue", "09324456782", "thienpro@gmail.com", "Male", 6);
        CustomerService cus = new CustomerService();
        cus.add(ct1);
        cus.add(ct2);
        cus.add(ct3);
        cus.add(ct4);
        cus.add(ct5);
        menu(cus);
    }

}

