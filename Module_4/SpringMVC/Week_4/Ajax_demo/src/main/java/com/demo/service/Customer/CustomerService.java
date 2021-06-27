package com.demo.service.Customer;

import com.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CustomerService implements ICustomerService{

    @Autowired
    private ICustomerService customerService;
    @Override
    public Iterable<Customer> findAll() {
        return customerService.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerService.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerService.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerService.remove(id);
    }
}
