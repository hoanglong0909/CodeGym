package com.product.dao;

import com.product.model.Category;
import com.product.model.Product;
import com.product.service.iProductService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends BaseDAO implements iProductService<Product> {

    private static final String SEARCH_PRODUCT_SQL ="select * from product where productName like  ?;";
    public List<Product> searchProduct(String keyword) throws SQLException {
        String keyWord = "%"+keyword+"%";
        List<Product> productList = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCT_SQL);
        preparedStatement.setString(1, keyWord);
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String productName = rs.getString("productName");
            productList.add(new Product(id, productName));
        }
        return productList ;
    }



    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product (productName,Price,Quantity,Color, idCategory) VALUES (?, ?, ?,?, ?);";
    @Override
    public void insert(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCT_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getCategory().getId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private static final String SELECT_PRODUCT_BY_ID = "SELECT id,productName,Price,Quantity,Color from product where id = ?;";
    @Override
    public Product selectOne(int id) {
        Product product = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String productName = rs.getString("productName");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                Category category = new Category(rs.getInt("idCategory"), rs.getString("categoryName"));
                product = new Product(id,productName, price, quantity,color,category);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }



    private static final String SELECT_ALL_PRODUCT = "SELECT p.*,c.categoryName FROM product p inner join category c on c.id = p.idCategory";
    @Override
    public List<Product> selectAll() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                float price = rs.getFloat("Price");
                int quantity = rs.getInt("Quantity");
                String color = rs.getString("Color");
                Category category = new Category(rs.getInt("idCategory"), rs.getString("categoryName"));
                productList.add(new Product(id, productName, price, quantity,color, category));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return productList;
    }

    private static final String SELECT_PRODUCT_ALL = "SELECT *  from product" ;
    @Override
    public List<Product> selectProductAll() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_ALL)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("productName");
                float price = rs.getFloat("Price");
                int quantity = rs.getInt("Quantity");
                String color = rs.getString("Color");

                productList.add(new Product(id, productName, price, quantity,color));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return productList;
    }


    private static final String DELETE_PRODUCT_SQL = "delete from product where id = ?;";
    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }



    private static final String UPDATE_USERS_SQL = "update product set productName = ?,Price= ?, Quantity =?,Color= ? where id = ?;";
    @Override
    public boolean update(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, product.getProductName());
            statement.setFloat(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setInt(5, product.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }


}
