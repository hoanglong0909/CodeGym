package com.manager.service.customer;

import com.manager.model.Customer;
import com.manager.repository.ICustomerRepotsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepotsitory customerRepotsitory;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepotsitory.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepotsitory.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepotsitory.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepotsitory.deleteById(id);
    }

}
