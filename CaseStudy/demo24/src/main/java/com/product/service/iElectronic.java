package com.product.service;

import com.product.model.Category;
import com.product.model.Electronic;

import java.sql.SQLException;
import java.util.List;

public interface iElectronic {
    void insert(Electronic electronic) throws SQLException;
    Electronic select(int id) throws SQLException;
    List<Electronic> selectAll() throws SQLException;
    List<Electronic> getProductCid(int id) throws SQLException;
    Electronic getProductById(int id) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean update(Electronic electronic) throws SQLException;
    Category selectCategory(int id) throws SQLException;
    List<Category> selectCategoriesAll() throws SQLException;
}
