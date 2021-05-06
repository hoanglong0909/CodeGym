package com.contact.presentation;

import com.contact.model.Contact;
import com.contact.service.ContactService;

import java.io.IOException;
import java.util.Scanner;

public class MainContact {

    public static void showMenu(){
        while (true){
            System.out.println("Chào bạn đến với hệ thống !");
            System.out.println();
            System.out.println("1. Nhập 1 để thêm mới danh bạ.");
            System.out.println("2. Nhập 2 để in ra danh bạ.");
            System.out.println("3. Nhập 3 để sữa danh bạ");
            System.out.println("4. Nhập 4 dể tìm kiếm danh bạ.");
            System.out.println("5. Nhập 5 để xóa danh bạ");
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            switch (choose){
                case 0:
                    System.out.println("CẢm ơn bạn đã swrr dụng dịch vụ của chúng tôi");
                    return;
                case 1:
                    try {
                        addContact();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2: printContact();
                break;
                case 3:
                    try {
                        editContact();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4: searchContact();
                break;
                case 5: deleteContact();
            }
        }
    }


    public static void main(String[] args) {
        ContactService contactService = new ContactService();
        try {
            contactService.loadContact();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showMenu();
    }


    private static void searchContact() {
        ContactService contactService = new ContactService();
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.nextLine();
        if(contactService.searchPhone(phone) == null){
            System.out.println("Không tim thấy phone ! ");
        }else {
            System.out.println(contactService.searchPhone(phone));
        }
        System.out.println("Bấm menu để tiếp tục thực hiện");
        System.out.println("=======================================");
    }

    private static void deleteContact() {
        System.out.println("Nhập vào số điện thoại khach hàng muốn xóa");
        ContactService contactService = new ContactService();
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.nextLine();
        if(contactService.searchPhone(phone) == null) {
            System.out.println("Không tim thấy phone ! ");
        }else {
            contactService.removeFile(phone);
            System.out.println("Đã xóa thành công");
        }
    }

    private static void printContact() {
        ContactService contactService = new ContactService();
        contactService.printFile();
    }

    private static void editContact() throws IOException {
        ContactService contactService = new ContactService();
        System.out.println("Nhập số điện thoại khách hàng muốn sửa : ");
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.nextLine();
        if(contactService.searchPhone(phone) == null) {
            System.out.println("Không tim thấy phone ! ");
        }else {
            Contact contact = new ContactService().searchPhone(phone);
            String name = contactService.inputName();
            String age  = contactService.inputAge();
            String dob = contactService.inputDob();
            String address = contactService.inputAadress();
            String phones = contactService.inputPhone();
            String email = contactService.inputEmail();
            String oder = contactService.inputOder();
            contact.setName(name);
            contact.setAge(age);
            contact.setDob(dob);
            contact.setAddress(address);
            contact.setPhone(phones);
            contact.setEmail(email);
            contact.setOder(oder);
            contactService.addFile(contact);
        }
    }

    private static void addContact() throws IOException {
        ContactService contactService = new ContactService();
        String name = contactService.inputName();
        String age  = contactService.inputAge();
        String dob = contactService.inputDob();
        String address = contactService.inputAadress();
        String phone = contactService.inputPhone();
        String email = contactService.inputEmail();
        String oder = contactService.inputOder();
        Contact contact = new Contact(name,age,dob,address,phone,email,oder);
        contactService.addFile(contact);
    }
}
