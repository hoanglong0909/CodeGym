package com.MagingTrainess.service;

import com.MagingTrainess.data.StudenDB;
import com.MagingTrainess.model.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentService {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[\\pL ]{2,30}$");
    public StudenDB studenDB = new StudenDB();


    public void updateFIle(){
        try {
            studenDB.saveFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadFile(){
        try {
            studenDB.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


// THiết lập id:
    public int validateID(String mess) {
        System.out.println(mess);
        try {
            System.out.println("Mời nhập id");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            if (id == 0) return 0;
            if (id > 0) {
                for (Student student : StudenDB.studentHashMap.values()) {
                    if (student.getId() == id) {
                        return id;
                    }
                }
            }
            throw new Exception();
        } catch (Exception e) {
            System.err.println("ID không hợp lệ hoặc không tồn tại học viên này!");
            return validateID(mess);
        }
    }
//thiết lập ngày tháng năm
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

    //Tiết lập kiểu nhập int
    public int getInt() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
// ngày
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
//tháng
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
//năm
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
//thiết lập tháng
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
//thiết lập năm
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

//thiết lập tên
    public String validateName(String mess) {
        System.out.println(mess);
        try {
            Scanner scanner = new Scanner(System.in);
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


//thiết lập điểm số
    public double validatePoints(String mess) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mess);
        String input = sc.nextLine().toLowerCase();
        if (input.equals("x"))
            throw new IllegalArgumentException();
        try {
            double point = Double.parseDouble(input);
            if (point > 10 || point < 0) {
                throw new Exception();
            } else {
                return point;
            }
        } catch (Exception e) {
            System.err.println("Điểm phải trong khoảng [0 - 10]");
            return validatePoints(mess);
        }
    }
// Thiết lập in điểm
    public static void displayPoint(double point) {
        if (!(point == -1))
            System.out.format("%-10.2f |", point);
        else
            System.out.format("%-10s |", "Chưa nhập");
    }

    //thiết lập giới hạn số điểm
    public int findMaxNumberOfPoint() {
        int max = 0;
        for (Student item : StudenDB.studentHashMap.values()) {
            if (item.getPoinFactor1().size() > max) {
                max = item.getPoinFactor1().size();
            }
        }
        return max;
    }

    //thiết lập giới tính
    public String validateGender() {
        System.out.println("Nhập giới tính");
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Nam\n2. Nữ");
            int choise = scanner.nextInt();
            switch (choise) {
                case 1:
                    return "Nam";
                case 2:
                    return "Nữ";
                default:
                    throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("Nhập sai giới tính");
            return validateGender();
        }
    }



    public void add(Student student) throws IOException {
        StudenDB.studentHashMap.put(student.getId(),student);
        StudenDB studenDB = new StudenDB();
        studenDB.saveFile();
    }




    public void remove(int id){
        studenDB.remove(id);
    }


}
