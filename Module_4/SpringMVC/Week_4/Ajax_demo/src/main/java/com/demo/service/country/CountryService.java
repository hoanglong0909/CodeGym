package com.demo.service.country;

import com.demo.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;



public class CountryService implements ICountryService{

    @Autowired
    private ICountryService countryService;
    @Override
    public Iterable<Country> findAll() {
        return countryService.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryService.findById(id);
    }

    @Override
    public Country save(Country country) {
        return countryService.save(country);
    }

    @Override
    public void remove(Long id) {
        countryService.remove(id);
    }
}
