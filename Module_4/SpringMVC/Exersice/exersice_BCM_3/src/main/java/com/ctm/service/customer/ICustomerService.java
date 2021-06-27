package com.ctm.service.customer;

import com.ctm.model.Customer;

import java.util.Optional;
public interface ICustomerService {

    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    Customer save(Customer smartPhone);

    void remove(Long id);
}
