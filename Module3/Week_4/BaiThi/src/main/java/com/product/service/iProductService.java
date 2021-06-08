package com.product.service;

import java.sql.SQLException;
import java.util.List;

public interface iProductService<T> extends iBaseService<T> {
    List<T> searchProduct(String keyword) throws SQLException;

}


