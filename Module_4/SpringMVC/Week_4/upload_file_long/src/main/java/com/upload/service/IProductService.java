package com.upload.service;

import com.upload.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findBy(long id);
    Product saveProduct(Product product);
    void remove(long id);
}
