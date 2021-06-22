package com.gaming.ITF;

import com.gaming.model.Machine;

import java.sql.SQLException;
import java.util.List;

public interface ITFmachine {
    void insert(Machine machine)throws SQLException;
    Machine select(int idMachine )throws SQLException;
    List<Machine> selectAll()throws SQLException;
    boolean delete(int idMachine)throws SQLException;
    boolean update(Machine machine)throws SQLException;
}
