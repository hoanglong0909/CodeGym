package com.MagingTrainess.presentation;

import com.MagingTrainess.model.Student;
import com.MagingTrainess.service.StudentService;

import java.io.IOException;
import java.util.Scanner;

public class MainStudent {
    public static final String DASH_DECORATION = "_______________________________________________________________________________";
    public int validateNumberGreaterThan0(String mess) {
        System.out.println(mess);
        try {
            int num = getInt();
            if (num > -1) {
                return num;
            }
            throw new Exception();
        } catch (Exception e) {
            System.err.println("Nhập vào định dạng sai, mời nhập lại:");
            return validateNumberGreaterThan0(mess);
        }
    }
    public int getInt() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public void showMenu() throws IOException {
        while(true){
            System.out.println("Menu");
            System.out.println("1. Xem danh sách học viên");
            System.out.println("2. Thêm học viên");
            System.out.println("3. Sửa thông tin học viên");
            System.out.println("4. Xoá học viên");
            System.out.println("5. Nhập điểm học viên");
            System.out.println("6. Sửa điểm học viên");
            System.out.println("7. Xếp loại học viên");
            System.out.println("0. Thoát chương trình");
            int choose  = validateNumberGreaterThan0("Mời bạn nhập: ");
            switch (choose){
                case 1:
                    showStudentList();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    editStudentInfo();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    insertPoint();
                    break;
                case 6:
                    editPoints();
                    break;
                case 7:
                    gradingStudents();
                    break;
                case 0:
                    System.out.println("Cảm ơn đã sử dụng, tạm biệt!");
                    return;
                default:
                    System.err.println("Nhập sai, vui lòng nhập lại");
                    break;
            }
        }
    }

    private void gradingStudents() {
    }

    private void editPoints() {
    }

    private void insertPoint() {
    }

    private void deleteStudent() {
    }

    private void editStudentInfo() {
    }

    private void showStudentList() {
    }

    private void addStudent() throws IOException {
        int number = validateNumberGreaterThan0("Nhập số lượng học viên cần thêm: ");
        StudentService ss = new StudentService();
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập thông tin học sinh thứ " + (i + 1));
            String name = ss.validateName("Nhập tên:");
            String dob =ss.validateDoB("Nhập ngày tháng năm sinh");
            String gender = ss.validateGender();
            Student student = new Student(name, dob, gender);
            ss.add(student);
        }
        ss.loadFile();
    }

//    private void editPoints() {
//        while (true) {
//            Scanner scanner =new Scanner(System.in);
//            System.out.println("Menu Sửa điểm");
//            System.out.println("1. Sửa TỪNG điểm cho một học viên");
//            System.out.println("2. Sửa TOÀN BỘ điểm cho một học viên");
//            System.out.println("3. Sửa TOÀN BỘ điểm cho TOÀN BỘ học viên");
//            System.out.println("0. Trở về menu chính");
//            int choose = sc.nextInt();
//            switch (choose) {
//                case 1:
//                    editEachPoint();
//                    break;
//                case 2:
//                    editAllPoint();
//                    break;
//                case 3:
//                    editAllPointAllStudent();
//                    break;
//                case 0:
//                    return;
//                default:
//                    System.err.println("Nhập sai, vui lòng nhập lại");
//                    break;
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        MainStudent mainStudent = new MainStudent();
        mainStudent.showMenu();
    }

}
