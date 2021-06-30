package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Long> {
    Iterable<Customer> findAllByOrderByIdDesc();
}