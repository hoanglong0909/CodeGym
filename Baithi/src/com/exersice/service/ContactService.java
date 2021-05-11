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
            phoneNumber = scanner.nextLine();
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


    public int getInt() {
        return Integer.parseInt(scanner.nextLine());
    }
    public String validateDoB(String mess) {
        System.out.println(mess);
        try {
            int day = validateDay("Nhập ngày sinh:");
            int month = validateMonth("Nhập tháng:");
            int year = validateYear("Nhập năm sinh:");
            int dayLimit = validateDayMonth(month, year);
            if (day > dayLimit | day < 1)
                throw new Exception("Ngày phải trong khoảng [1 - " + dayLimit + "] (phụ thuộc vào tháng)");
            return day + "/" + month + "/" + year;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return validateDoB(mess);
        }
    }

    private int validateDay(String mess) {
        System.out.println(mess);
        try {
            int day = getInt();
            if (day < 1 | day > 31) throw new Exception();
            return day;
        } catch (Exception e) {
            System.err.println("Ngày sinh không hợp lệ");
            return validateDay(mess);
        }
    }

    private int validateMonth(String mess) {
        System.out.println(mess);
        try {
            int month = getInt();
            if (month < 1 | month > 12) throw new Exception();
            return month;
        } catch (Exception e) {
            System.err.println("Tháng không hợp lệ");
            return validateMonth(mess);
        }
    }




    private int validateYear(String mess) {
        System.out.println(mess);
        try {
            int year = getInt();
            if (limitYear(year)) {
                System.err.println("Năm sinh phải trong khoảng [1930 - 2019]");
                return validateYear(mess);
            }
            return year;
        } catch (Exception e) {
            System.err.println("Năm sinh không hợp lệ");
            return validateYear(mess);
        }
    }


    private int validateDayMonth(int month, int year) throws Exception {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (checkLeapYear(year))
                    return 29;
                else return 28;
            default:
                throw new Exception("Tháng phải trong khoảng [1 - 12]");
        }
    }

    public boolean limitYear(int year) {
        return year <= 1930 || year >= 2020;
    }

    private boolean checkLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 4 == 0 && year % 100 != 0)
            return true;
        return false;
    }

}
