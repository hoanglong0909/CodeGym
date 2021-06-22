package com.product.service;

import com.product.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    public static Map<Integer, Product> productMap;
    static {
        productMap = new HashMap<>();
        productMap.put(1,new Product(1,"iphone",2000,"usa","john"));
        productMap.put(2,new Product(2,"iphone",2000,"usa","john"));
        productMap.put(3,new Product(3,"iphone",2000,"usa","john"));
        productMap.put(4,new Product(4,"iphone",2000,"usa","john"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
