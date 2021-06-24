package com.manager.service.city;

import com.manager.model.City;
import com.manager.repository.ICityRepotsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CityService implements ICityService {
    @Autowired
    private ICityRepotsitory cityRepotsitory;

    @Override
    public Iterable<City> findAll() {
        return cityRepotsitory.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepotsitory.findById(id);
    }

    @Override
    public void save(City city) {
        cityRepotsitory.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepotsitory.deleteById(id);
    }
}
