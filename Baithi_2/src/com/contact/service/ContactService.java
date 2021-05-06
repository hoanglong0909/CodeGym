package com.contact.service;

import com.contact.data.ContactDB;
import com.contact.model.Contact;

import java.io.IOException;
import java.util.Scanner;

public class ContactService {

    ContactDB contactDB = new ContactDB();
    Scanner scanner = new Scanner(System.in);


    public void addFile(Contact contact) throws IOException {
        for (int i = 0; i < ContactDB.contactList.size(); i++) {
            if (ContactDB.contactList.get(i).getPhone().equals(contact.getPhone())||ContactDB.contactList.get(i).getEmail().equals(contact.getEmail())){
                System.out.println("He thong da ton tai!");
                return;
            }
        }
        System.out.println("Đã thêm thành công vào danh bạ");
        contactDB.add(contact);
        contactDB.saveFile();
    }


    public Contact searchPhone(String phone){
        for (int i = 0; i <ContactDB.contactList.size() ; i++) {
            if(ContactDB.contactList.get(i).getPhone().equals(phone)){
                return ContactDB.contactList.get(i);
            }
        }
        return null;
    }



    public void printFile(){
        if(ContactDB.contactList.isEmpty()){
            System.out.println("Không có số nào trong danh bạ !");
        }else {
            int count = 0;
            for (int i = 0; i <ContactDB.contactList.size() ; i++) {
                ++count;
                System.out.println(count + ". "+ ContactDB.contactList.get(i).toString());
            }
            System.out.println("Có tổng số "+ ContactDB.contactList.size() + " Người dùng trong danh bạ");
        }
    }


    public void removeFile(String phone) {
        if (searchPhone(phone) != null) {
            ContactDB.contactList.remove(searchPhone(phone));
        }
    }

    public void updateContact() throws IOException {
        contactDB.saveFile();
    }
    public void loadContact() throws IOException {
        contactDB.readFile();
    }
    public String inputName(){
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        return name;
    }
    public String inputAge(){
        System.out.println("Nhập tuổi: ");
        String age = scanner.nextLine();
        return age;
    }
    public String inputDob(){
        System.out.println("Nhập ngày tháng năm sinh: ");
        String dob = scanner.nextLine();
        return dob;
    }
    public String inputAadress(){
        System.out.println("Nhập địa chỉ: ");
        String aadress = scanner.nextLine();
        return aadress;
    }
    public String inputPhone(){
        System.out.println("Nhập Phone: ");
        String phone = scanner.nextLine();
        return phone;
    }
    public String inputEmail(){
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();
        return email;
    }
    public String inputOder(){
        System.out.println("Nhập Oder: ");
        String oder = scanner.nextLine();
        return oder;
    }

}
