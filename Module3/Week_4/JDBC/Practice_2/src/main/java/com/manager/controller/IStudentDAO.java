package com.manager.controller;

import com.manager.controller.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {
    public void insertStudentDAO(Student student) throws SQLException;
    public Student selectStudentDAO(int id) throws SQLException;
    public List<Student>selectStudentAll() throws SQLException;
    public boolean deleteStudentDAO(int id) throws SQLException;
    public boolean updateStudentDAO(Student student) throws SQLException;
}
