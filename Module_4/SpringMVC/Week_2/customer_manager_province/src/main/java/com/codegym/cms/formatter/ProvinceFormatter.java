package com.codegym.cms.formatter;

import com.codegym.cms.model.Country;
import com.codegym.cms.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ProvinceFormatter implements Formatter<Country> {

    private IProvinceService provinceService;

    @Autowired
    public ProvinceFormatter(IProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        Optional<Country> provinceOptional = provinceService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(Country object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}