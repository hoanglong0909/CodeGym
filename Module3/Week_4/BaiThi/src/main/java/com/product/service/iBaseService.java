package com.product.service;

import com.product.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface iBaseService<T> {
    void insert(T t) throws SQLException;

    T selectOne(int id);

    List<T> selectAll();

    List<T> selectProductAll();

    boolean delete(int id) throws SQLException;

    boolean update(T t) throws SQLException;
}
