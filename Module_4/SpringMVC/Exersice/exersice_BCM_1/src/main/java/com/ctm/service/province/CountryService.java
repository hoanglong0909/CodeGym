package com.ctm.service.province;

import com.ctm.model.Country;
import com.ctm.repository.ICountryRepository;
import com.ctm.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CountryService implements ICountryService {

    @Autowired
    private ICountryRepository countryRepository;


    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
        countryRepository.deleteById(id);
    }
}