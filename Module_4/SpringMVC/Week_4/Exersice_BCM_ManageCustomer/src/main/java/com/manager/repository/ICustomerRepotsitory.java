package com.manager.repository;

import com.manager.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerRepotsitory extends PagingAndSortingRepository<Customer,Long> {
}
