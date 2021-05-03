package com.Managin.presentation;

import com.Managin.data.StudentData;
import com.Managin.model.Student;
import com.Managin.service.StudentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainStudent {

    public static void main(String[] args) throws IOException {
        MainStudent ms = new MainStudent();
        ms.showMenu();
    }

    public static final String DASH_DECORATION = "--------------------------------------------------------------------------------------------------------------------";

    Scanner sc = new Scanner(System.in);

    public void showMenu() throws IOException {
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
            int choose = sc.nextInt();
            switch (choose) {
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



    private void editPoints() {
        while (true) {
            System.out.println("Menu Sửa điểm");
            System.out.println("1. Sửa TỪNG điểm cho một học viên");
            System.out.println("2. Sửa TOÀN BỘ điểm cho một học viên");
            System.out.println("3. Sửa TOÀN BỘ điểm cho TOÀN BỘ học viên");
            System.out.println("0. Trở về menu chính");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    editEachPoint();
                    break;
                case 2:
                    editAllPoint();
                    break;
                case 3:
                    editAllPointAllStudent();
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Nhập sai, vui lòng nhập lại");
                    break;
            }
        }
    }

    private void editAllPointAllStudent() {
    }

    private void editAllPoint() {
    }

    private void editEachPoint() {
    }

    private void gradingStudents() {
    }


    private void insertPoint() {
    }

    private void showStudentList() {
        List<Student> listStudent = new ArrayList<>(StudentData.studentMap.values());
        showStudent(listStudent, listStudent.size());
    }


    private void showStudent( List<Student> students, int size) {

        System.out.println(DASH_DECORATION);
        System.out.format("||%-3s |", "ID");
        System.out.format("%-30s |", "Tên");
        System.out.format("%-12s |", "Ngày sinh");
        System.out.format("%-12s |", "Giới tính");
        System.out.format("%-10s |", "Điểm hs1");
        System.out.format("%-10s |", "Điểm hs2");
        System.out.format("%-10s |", "Điểm hs3");
        System.out.format("%-10s ||\n", "Điểm TB");
        System.out.println(DASH_DECORATION);
        try {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < findMaxNumberOfPoint(); j++) {
                    if (students.get(i) != null) {
                        if (j == 0) {
                            System.out.format("||%-3d |", students.get(i).getId());
                            System.out.format("%-30s |", students.get(i).getName());
                            System.out.format("%-12s |", students.get(i).getDob());
                            System.out.format("%-12s |", students.get(i).getGender());
                            displayPoint(students.get(i).getPointFactor1().get(j));
                            displayPoint(students.get(i).getPointFactor2().get(j));
                            displayPoint(students.get(i).getPointFactor3().get(j));
                            displayPoint(students.get(i).getAveragePoint());
                            System.out.println("|");
                        } else {
                            System.out.format("||%-3s |", "");
                            System.out.format("%-30s |", "");
                            System.out.format("%-12s |", "");
                            System.out.format("%-12s |", "");
                            try {
                                displayPoint(students.get(i).getPointFactor1().get(j));
                            } catch (IndexOutOfBoundsException e) {
                                System.out.format("%-10s |", " ");
                            }
                            try {
                                displayPoint(students.get(i).getPointFactor2().get(j));
                            } catch (IndexOutOfBoundsException e) {
                                System.out.format("%-10s |", " ");
                            }
                            try {
                                displayPoint(students.get(i).getPointFactor3().get(j));
                            } catch (IndexOutOfBoundsException e) {
                                System.out.format("%-10s |", " ");
                            }
                            System.out.format("%-10s ||\n", "");
                        }
                    } else {
                        System.out.print("");
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.print("");
        }
        System.out.println(DASH_DECORATION);
    }
    public int findMaxNumberOfPoint() {
        int max = 0;
        for (Student item : StudentData.studentMap.values()) {
            if (item.getPointFactor1().size() > max) {
                max = item.getPointFactor1().size();
            }
        }
        return max;
    }
    private void displayPoint(double point) {
        if (!(point == -1))
            System.out.format("%-10.2f |", point);
        else
            System.out.format("%-10s |", "Chưa nhập");
    }



    private void addStudent() throws IOException {
        System.out.println("Nhập số lượng học viên cần thêm ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập thông tin học sinh thứ " + (i + 1));
            System.out.println("Nhập tên");
            String name = sc.nextLine();
            String dob = validateDoB("Nhập ngày tháng năm sinh");
            System.out.println("Nhập giới tính: ");
            String gender = sc.nextLine();
            Student student = new Student(name, dob, gender);
            StudentData.studentMap.put(student.getId(), student);
        }
    }

    private void editStudentInfo() {
        Scanner sc = new Scanner(System.in);
        int id = validateID("Nhập ID để sửa, nhập 0 để trở về menu ");
        if (id == 0) return;
        System.out.println("Nhập tên mới:");
        String name = sc.nextLine();
        String dob = validateDoB("Nhập ngày tháng năm sinh");
        System.out.println("Nhập giới tính: ");
        String gender = sc.nextLine();
        StudentData.studentMap.get(id).setName(name);
        StudentData.studentMap.get(id).setDob(dob);
        StudentData.studentMap.get(id).setGender(gender);
            StudentService ss = new StudentService();
            ss.updateFile();
    }
    private void deleteStudent() {
        int id = validateID("Nhập ID để xóa, nhập 0 để trở về menu");
        if (id == 0) return;
        if (confirmMenu()) {
            StudentService.studentData.remove(id);
                StudentService ss = new StudentService();
                ss.updateFile();
        }
    }

    private boolean confirmMenu() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Bạn chắc chắn muốn xóa học viên này?\n1. Có\n2. Không");
            int choise = sc.nextInt();
            switch (choise) {
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    System.err.println("Chỉ 'Có' hoặc 'Không'!");
            }
        }
    }


    public String validateDoB(String mess) {
        System.out.println(mess);
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập ngày sinh:");
            int day = sc.nextInt();
            System.out.println("Nhập Tháng sinh:");
            int month = sc.nextInt();
            System.out.println("Nhập năm sinh:");
            int year = sc.nextInt();
            return day + "/" + month + "/" + year;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return validateDoB(mess);
        }
    }


    public int validateID(String mess) {
        System.out.println(mess);
        try {
            System.out.println("Mời nhập id");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            if (id == 0) return 0;
            if (id > 0) {
                for (Student student : StudentData.studentMap.values()) {
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

}

