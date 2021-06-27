package com.demo.service;

import com.demo.model.Smartphone;

import java.util.Optional;

public interface IGeneralService<T>  {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
}
