package com.codegym.cms.service.country;


import com.codegym.cms.model.Country;
import com.codegym.cms.repository.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceCountry implements IProvinceCountry {
    @Autowired
    private ICountryRepository provinceRepository;

    @Override
    public Iterable<Country> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return provinceRepository.findById(id);
    }

    @Override
    public Country save(Country country) {
       return provinceRepository.save(country);
    }

    @Override
    public void remove(Long id) {
        provinceRepository.deleteById(id);
    }
}