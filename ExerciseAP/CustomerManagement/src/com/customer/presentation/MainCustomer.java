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
        while(y != 6) {
            System.out.println("Chào mừng bạn đến với hệ thống quản lý khách hàng\nBấm 1 để nhập khách hàng\nBấm 2 để tìm kiếm khách hàng\nBam 3 để in thông tin khách hàng\nBam 4 để in toàn bộ danh sách khách hàng\nBam 5 để tăng số đơn hàng cho khách\nBam 0 để thoát khỏi chương trình !\n==========================================================");
            y = sc.nextInt();
            sc.nextLine();
            switch(y) {
                case 0:
                    System.exit(0);
                    System.out.println("CẢm ơn bạn đã sử dụng dịch vụ !");
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
        Customer cst1 = new Customer("trang", "Hue", "0782222595", "Trangnguyen1010@gmail.com", "nu", 1);
        Customer cst2 = new Customer("huy", "Hue", "0905234289", "hutle123@gmail.com", "nam", 2);
        Customer cst3 = new Customer("Phong", "hanoi", "0364334561", "suny12@gmail.com", "nam", 3);
        Customer cst4 = new Customer("khai", "haiphong", "0356754546", "sunsun@gmail.com", "nam", 4);
        Customer cst5 = new Customer("Long", "quangnam", "09324456782", "Longcun@gmail.com", "nam", 6);
        CustomerService cst = new CustomerService();
        cst.add(cst1);
        cst.add(cst2);
        cst.add(cst3);
        cst.add(cst4);
        cst.add(cst5);
        menu(cst);
    }

}

