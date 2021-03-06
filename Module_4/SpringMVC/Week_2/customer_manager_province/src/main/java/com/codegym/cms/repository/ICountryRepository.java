package com.codegym.cms.repository;

import com.codegym.cms.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends CrudRepository<Country, Long> {
}