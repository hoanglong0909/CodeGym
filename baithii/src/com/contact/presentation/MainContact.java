package com.contact.presentation;

import com.contact.model.Contact;
import com.contact.service.ContactService;

import java.io.IOException;
import java.util.Scanner;

public class MainContact {
    public static void main(String[] args) {
        try {
            showMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static  void showMenu() throws IOException {
        ContactService contactService = new ContactService();
        Scanner scanner = new Scanner(System.in);
        int  choose;
        contactService.loadFile();
        System.out.println("Chào mừng bạn đã đến với dịch vụ của chúng tôi !");
        System.out.println("1. Nhập 1 đê thêm khách hàng");
        System.out.println("2. Nhập 2 xem danh sách khách hàng");
        System.out.println("3. Nhập 3 sữa thông tin khách hàng");
        System.out.println("4. Nhập 4 để xóa khách hàng");
        System.out.println("5. Nhập 5 tìm thông tin khách hàng");
        System.out.println("0. Nhập 0 để thoát chương trình");
        do {
            choose = scanner.nextInt();

            switch (choose){
                case 1: addContact();
                    break;
                case 2:printContact();
                    break;
                case 3:editContact();
                    break;
                case 4: deleteContact();
                    break;
                case 5: searchContact();
                    break;
                case 0:
                    System.out.println("cảm ơn đã sử dụng dịch vụ !");
                    return;
                default:
                    System.out.println("bạn nhập sai mời nhập lại !");
                    break;
            }
        }while (choose != 6);
    }

    private static void deleteContact() {
    }

    private static void searchContact() {
        ContactService contactService = new ContactService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại cần tìm");
        String phoneNumber = scanner.nextLine();

        if(contactService.findPhone(phoneNumber) == null){
            System.out.println("Không tìm thấy khách hàng");
        }else {
            System.out.println(contactService.findPhone(phoneNumber));
        }
    }

    private static void editContact() {
    }

    private static void printContact() {
        ContactService contactService = new ContactService();
        contactService.printFile();

    }

    private static void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập name");
        String name = scanner.nextLine();
        System.out.println("Nhập sdt");
        String phoneNumber = scanner.nextLine();
        System.out.println("nhập email: ");
        String email = scanner.nextLine();
        System.out.println("Nhập aadress: ");
        String aadress = scanner.nextLine();
        System.out.println("Nhập ngày tháng năm sinh: ");
        String dob = scanner.nextLine();
        Contact contact = new Contact(name,phoneNumber,email,aadress,dob);
        ContactService contactService = new ContactService();
        contactService.addFile(contact);
    }
}
