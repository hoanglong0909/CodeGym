package com.demo.repository;

import com.demo.model.Country;
import com.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends CrudRepository<Country,Long> {

}
