package com.Managerment.presentation;

import com.Managerment.model.Customer;
import com.Managerment.service.CustomerService;

import java.io.IOException;
import java.util.Scanner;

public class MainCustomer {
    public static void main(String[] args) {
        CustomerService  customerService = new CustomerService();
        Scanner scanner = new Scanner(System.in);
        customerService.loadFile();
        int choose;
        do {
            createMenu();
            choose = scanner.nextInt();
            switch (choose){
                case 1:
                    try {
                        addCustomer();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2: findCustomer();
                    break;
                case 3: printCustomer();
                    break;
                case 4: allprintCustomer();
                    break;
                case 5: moreOder();
                    break;
                case 6: editCustomer();
                break;
                case 0:
                    System.out.println("cảm ơn đã sử dụng dich vụ");
                    return;
                default:
                    System.out.println("bạn nhập sai mời nhập lại");
                    break;
            }
        }while (choose != 7);
    }

    private static void editCustomer() {
            Scanner sc =new Scanner(System.in);
            System.out.println("Nhap Id can edit");
            int phone = sc.nextInt();
            sc.nextLine();
            CustomerService customerService = new CustomerService();
            Customer customer = customerService.searchInfor(phone);
            if (customer == null){
                System.out.println("Not found");
            } else {
                System.out.println(customer.toString());
                System.out.println("Nhap ten:");
                String name = sc.nextLine();
                System.out.println("Nhập số điện thoại: ");
                int phonenumber = sc.nextInt();
                sc.nextLine();
                System.out.println("Nhap gioi tinh:");
                String gender = sc.nextLine();
                System.out.println("Nhập địa chỉ: ");
                String address = sc.nextLine();
                System.out.println("Nhập email: ");
                String email = sc.nextLine();
                System.out.println("Nhập lại đơn hàng: ");
                int oder = sc.nextInt();
                sc.nextLine();
                customer.setName(name);
                customer.setPhone(phonenumber);
                customer.setGender(gender);
                customer.setEmail(email);
                customer.setAddress(address);
                customer.setOder(oder);
                customerService.updateFile();
            }
    }

    private static void moreOder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại của khách hàng cần thêm : ");
        int phone = scanner.nextInt();
        scanner.nextLine();
        System.out.println("nhập số đơn hàng muốn thêm");
        int n = scanner.nextInt();
        CustomerService customerService = new CustomerService();
        customerService.moreOder(phone,n);
    }

    private static void allprintCustomer(){
        CustomerService customerService = new CustomerService();
        customerService.printFile();

    }
    private static void printCustomer() {
        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerService();
        System.out.println("Nhập số điện thoại của khách hàng: ");
        int phone = scanner.nextInt();
        customerService.searchInfor(phone);
        System.out.println("Bấm theo menu để tiếp tục thực hiện: ");
        System.out.println("=======================================");
    }

    private static void findCustomer() {
        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerService();
        int phone = scanner.nextInt();
        customerService.searchInfor(phone);
        System.out.println("Bấm theo menu để tiếp tục thực hiện");
        System.out.println("=======================================");
    }

    private static void addCustomer() throws IOException {
        CustomerService customerService = new CustomerService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập số điện thoại: ");
        int phone = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Mời bạn nhập email: ");
        String email = scanner.nextLine();
        System.out.println("mời bạn nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.println("Mời bạn nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Mời bạn nhập đơn hàng: ");
        int oder = scanner.nextInt();
        scanner.nextLine();
        Customer customer = new Customer(name,phone,email,gender,address,oder);
        customerService.addFile(customer);
        System.out.println("Bạn đã thêm thành công " + name +" vào danh sách");
    }
    public static void createMenu(){
        System.out.println("Chào mừng bạn đã đến với dịc vụ của chúng tôi !");
        System.out.println("1.Bấm 1 để nhập khách hàng");
        System.out.println("2. Bấm 2 để tìm kiếm khách hàng ");
        System.out.println("3. Bấm 3 để in thông tin khách hàng ");
        System.out.println("4. Bấm 4 để in toàn bộ danh sách khách hàng ");
        System.out.println("5. Bấm 5 để tăng số đơn hàng cho khách ");
        System.out.println("6. Bấm 6 để sữa lại khách");
        System.out.println("Bấm 0 để thoát dịch vụ");
        System.out.println("====================================================");
    }
}

