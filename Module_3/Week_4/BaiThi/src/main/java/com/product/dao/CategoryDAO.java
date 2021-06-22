package com.product.dao;


import com.product.model.Category;
import com.product.model.Product;
import com.product.service.iCategoryService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends BaseDAO implements iCategoryService<Category> {

    @Override
    public void insert(Category category) throws SQLException {

    }

    final String SELECT_CATEGORY_BY_ID = "select * from category where id = ?";
    @Override
    public Category selectOne(int id) {
        Category category = new Category();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("categoryName");
                category.setId(id);
                category.setCategoryName(name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return category;
    }

    final String SELECT_ALL_CATEGORY = "select * from category";
    @Override
    public List<Category> selectAll() {
        List<Category> categoryList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String categoryName = rs.getString("categoryName");
                categoryList.add(new Category(id, categoryName));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return categoryList;
    }

    @Override
    public List<Category> selectProductAll() {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Category category) throws SQLException {
        return false;
    }
}
