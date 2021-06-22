package com.DAO;

import com.model.Staff;

import java.sql.SQLException;
import java.util.List;

public interface iStaff {
    void insert(Staff staff) throws SQLException;
    Staff select(int id) throws SQLException;
    List<Staff> selectAll() throws  SQLException;
    boolean delete(int id) throws  SQLException;
    boolean update(Staff staff) throws SQLException;
}
