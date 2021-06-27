package com.ctm.controller;


import com.ctm.model.Country;
import com.ctm.service.customer.CustomerService;
import com.ctm.service.province.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/provinces")
    public ModelAndView listProvinces() {
        Iterable<Country> provinces = countryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/country/list");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/create-country")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/country/create");
        modelAndView.addObject("country", new Country());
        return modelAndView;
    }

    @PostMapping("/create-country")
    public ModelAndView saveProvince(@ModelAttribute("province") Country country) {
        countryService.save(country);
        ModelAndView modelAndView = new ModelAndView("/country/create");
        modelAndView.addObject("country", new Country());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-country/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Country> province = countryService.findById(id);
        if (province.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/country/edit");
            modelAndView.addObject("country", province.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-country")
    public ModelAndView updateProvince(@ModelAttribute("country") Country country) {
        countryService.save(country);
        ModelAndView modelAndView = new ModelAndView("/country/edit");
        modelAndView.addObject("country", country);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-country/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Country> province = countryService.findById(id);
        if (province.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/country/delete");
            modelAndView.addObject("country", province.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-country")
    public String deleteProvince(@ModelAttribute("province") Country country) {
        countryService.remove(country.getId());
        return "redirect:provinces";
    }
}