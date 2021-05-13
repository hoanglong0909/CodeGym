package com.manager.presentation;

import com.manager.service.StudentService;
import java.io.IOException;
import java.util.*;

public class MainStudent {
    StudentService studentService = new StudentService();
    public void showMenu() throws IOException {
//        studentService.loadFile();
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Xem danh sách học viên");
            System.out.println("2. Thêm học viên");
            System.out.println("3. Sửa thông tin học viên");
            System.out.println("4. Xoá học viên");
            System.out.println("5. Nhập điểm học viên");
            System.out.println("6. Sửa điểm học viên");
            System.out.println("7. Xếp loại học viên");
            System.out.println("0. Thoát chương trình");
            System.out.println("____________________________________________");
            Scanner scanner =new Scanner(System.in);
            System.out.println("Mời nhập");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    studentService.showStudentList();
                    break;
                case 2:
                    studentService.addStudent();
                    break;
                case 3:
                    studentService.editStudentInfo();
                    break;
                case 4:
                    studentService.deleteStudent();
                    break;
                case 5:
                    studentService.insertPoint();
                    break;
                case 6:
                    studentService.editPoints();
                    break;
                case 7:
                    studentService.gradingStudents();
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

    public static void main(String[] args) throws IOException {
        MainStudent student = new MainStudent();
        student.showMenu();
        student.studentService.updateFile();
    }
}


