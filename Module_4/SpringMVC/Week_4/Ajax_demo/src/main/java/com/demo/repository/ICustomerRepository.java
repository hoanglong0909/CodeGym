package com.demo.repository;

import com.demo.model.Customer;
import com.demo.model.Smartphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository  extends CrudRepository<Customer,Long> {
}
