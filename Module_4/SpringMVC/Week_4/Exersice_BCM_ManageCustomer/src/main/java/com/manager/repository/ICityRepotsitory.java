package com.manager.repository;

import com.manager.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICityRepotsitory extends PagingAndSortingRepository<City,Long> {
}
