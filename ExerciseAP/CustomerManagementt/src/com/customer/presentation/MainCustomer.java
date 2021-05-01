package com.customer.presentation;
import com.customer.model.Customer;
import com.customer.service.CustomerService;
import java.io.IOException;
import java.util.Currency;
import java.util.Scanner;

public class MainCustomer {
    public static void main(String[] args) throws IOException {
        CustomerService service = new CustomerService();
//        Customer ct1 = new Customer("Khanh", "Hue", "0782222595", "phuockhanh1010@gmail.com", "Male", "5");
//        Customer ct2 = new Customer("Duong", "Hue", "0905234289", "duongvat@gmail.com", "Male", "2");
//        Customer ct3 = new Customer("Phong", "Hue", "0364334561", "phongpro113@gmail.com", "Male", "7");
//        Customer ct4 = new Customer("Han", "Hue", "0356754546", "hanny@gmail.com", "Male", "1");
//        Customer ct5 = new Customer("Thien", "Hue", "09324456782", "thienpro@gmail.com", "Male", "2");
//        CustomerService cus = new CustomerService();
//        cus.add(ct1);
//        cus.add(ct2);
//        cus.add(ct3);
//        cus.add(ct4);
//        cus.add(ct5);
        try {
            service.loadFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            createMenu();
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    try {
                        addCustomer();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    searchCustomer();
                    break;
                case 3:
                    printCustomer();
                    break;
                case 4:
                    printAllCustomer();
                    break;
                case 5:
                    moreCustomer();
                    break;
                case 0:
                    System.out.println("Quit !");
                    break;
                default:
                    System.out.println("Mời bạn nhập lại: ");
                    break;
            }
        }while (choose!=0);
    }

    private static void moreCustomer() {
    }

    private static void printAllCustomer() {
        CustomerService cs = new CustomerService();
        cs.print();
    }

    private static void printCustomer() {
        System.out.println("Danh sách tất cả các khách hàng");
    }

    private static void searchCustomer() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhập số điện thoại để tìm kiếm khách hàng: ");
//        String phoneNumber = scanner.nextLine();
//        CustomerService customerService = new CustomerService();
//        Customer customer = customerService.find(phoneNumber);
//        if(customer == null){
//            System.out.println("Tìm không thấy ");
//        }else {
//            System.out.println("tìm thấy");1
//        }
    }

    private static void addCustomer() throws IOException {
        Scanner sc = new Scanner(System.in);
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
        String orderNumber = sc.nextLine();
        CustomerService cs = new CustomerService();
        cs.add(new Customer(name, address, phone, email, gender, orderNumber));
        System.out.println("Bạn vừa thêm mới khách hàng " +name +" Thành công !");
        System.out.println("Chọn Menu để tiếp tục ");
        System.out.println("=====================================================");
    }

    public static void createMenu(){
        System.out.println("chào mừng bạn đến với hệ thống quản lý khách hàng");
        System.out.println("Bấm 1 để nhập khách hàng");
        System.out.println("Bấm 2 để tìm kiếm khách hàng");
        System.out.println("bấm 3 để in thông tin khách hàng");
        System.out.println("bấm 4 để in toàn bộ danh sách khách hàng");
        System.out.println("Bấm 5 để tăng số đơn hàng cho khách");
        System.out.println("Bấm 0 để thoát");
        System.out.println("=====================================================");
    }
}

