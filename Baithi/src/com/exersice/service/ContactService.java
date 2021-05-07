package com.exersice.service;

import com.exersice.data.ContactDB;
import com.exersice.model.Contact;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactService {
    Scanner scanner = new Scanner(System.in);
    private static final Pattern NAME_PATTERN = Pattern.compile("^[\\pL ]{2,30}$");
    ContactDB contactDB = new ContactDB();


    public void addFile(Contact contact) throws IOException {
        for (int i = 0; i < ContactDB.contactArrayList.size(); i++) {
            if (ContactDB.contactArrayList.get(i).getPhone().equals(contact.getPhone()) || ContactDB.contactArrayList.get(i).getEmail().equals(contact.getEmail())) {
                System.out.println("He thong da ton tai!");
                return;
            }
        }
        System.out.println("Thêm thành công Khách hàng vào danh ssách");
        contactDB.add(contact);
//        contactDB.saveFile();
    }
    public void saveCT() throws IOException {
        contactDB.saveFile();
    }
    public void readCT() throws IOException {
        contactDB.readFile();
    }


    public void updateFile() throws IOException {
        contactDB.saveFile();
    }


    public void loadFile() throws IOException {
        contactDB.readFile();
    }


    public Contact findPhone(String phone) {
        for (int i = 0; i < ContactDB.contactArrayList.size(); i++) {
            if (ContactDB.contactArrayList.get(i).getPhone().equals(phone)) {
                return ContactDB.contactArrayList.get(i);
            }
        }
        return null;
    }


    public void removeFile(String phone) {
        if (findPhone(phone) != null) {
            ContactDB.contactArrayList.remove(findPhone(phone));
        }
    }


    public void printFile() {
        if (ContactDB.contactArrayList.isEmpty()) {
            System.out.println("Không có số nào trong danh bạ !");
        } else {
            int count = 0;
            for (int i = 0; i < ContactDB.contactArrayList.size(); i++) {
                ++count;
                System.out.println(count + ". " + ContactDB.contactArrayList.get(i).toString());
            }
            System.out.println("Có tổng số " + ContactDB.contactArrayList.size() + " Người dùng trong danh bạ");
        }
    }

    public String inputPhoneNumber() {
        String phoneNumber;
        do {
            System.out.println("Nhập số điện thoại: ");
            phoneNumber = new Scanner(System.in).nextLine();
        } while (!checkPhoneNumber(phoneNumber));
        return phoneNumber;
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        String regex = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find();
    }

    public String validateName(String mess) {
        System.out.println(mess);
        try {
            String name = scanner.nextLine();
            if (!NAME_PATTERN.matcher(name).matches()) {
                throw new Exception();
            }
            name = name.toLowerCase();
            name = name.trim();
            while (name.contains("  ")) {
                name = name.replace("  ", " ");
            }
            String[] str = name.split("");
            str[0] = str[0].toUpperCase();
            StringBuilder nameBuilder = new StringBuilder(str[0]);
            for (int i = 1; i < str.length; i++) {
                if (str[i].equals(" ")) {
                    str[i + 1] = str[i + 1].toUpperCase();
                }
                nameBuilder.append(str[i]);
            }
            return nameBuilder.toString();
        } catch (Exception e) {
            System.err.println("Tên không được có số, để trống hoặc quá dài (30)");
            return validateName(mess);
        }
    }

    public String inputEmail() {
        String email;
        do {
            System.out.println("Nhập vào email: ");
            email = scanner.nextLine();
        } while (!checkEmail(email));
        return email;
    }

    public boolean checkEmail(String email) {
        String regex = "^[a-zA-Z]+[a-zA-Z0-9]*@{1}\\w+mail.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.find() ? true : false;
    }

    public String inputFacebook() {
        System.out.println("Nhập tên facebook: ");
        String facebook = scanner.nextLine();
        return facebook;
    }
}
