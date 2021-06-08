package com.gaming.ITF;

import com.gaming.model.Service;

import java.sql.SQLClientInfoException;
import java.util.List;

public interface ITFservice {
    void insert(Service service) throws SQLClientInfoException;
    Service select(int idProduct) throws SQLClientInfoException;
    List<Service> selectAll() throws SQLClientInfoException;
    boolean delete(int idProduct) throws SQLClientInfoException;
    boolean update(Service service) throws SQLClientInfoException;
}
