package com.service;

import com.model.Category;
import com.model.Electronic;

import java.sql.SQLException;
import java.util.List;

public interface iElectronic {
    void insert(Electronic electronic) throws SQLException;
    Electronic select(int id) throws SQLException;
    List<Electronic> selectAll() throws SQLException;
    List<Electronic> getProductCid(int id) throws SQLException;
    Electronic getProductById(int id) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean update(String name,String image,Float price,int categoryId,int id) throws SQLException;
    Category selectCategory(int id) throws SQLException;
    List<Category> selectCategoriesAll() throws SQLException;
    List<Electronic> getProductBySellId(int id) throws SQLException;
    void insertProduct(Electronic electronic) throws SQLException;
}
