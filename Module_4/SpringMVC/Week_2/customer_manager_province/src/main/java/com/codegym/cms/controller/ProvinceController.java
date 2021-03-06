package com.codegym.cms.controller;




import com.codegym.cms.model.Country;
import com.codegym.cms.service.customer.CustomerService;
import com.codegym.cms.service.country.ProvinceCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.Optional;

@Controller
public class ProvinceController {
    @Autowired
    private ProvinceCountry provinceService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/countries")
    public ModelAndView listProvinces() {
        Iterable<Country> provinces = provinceService.findAll();
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
        provinceService.save(country);
        ModelAndView modelAndView = new ModelAndView("/country/create");
        modelAndView.addObject("country", new Country());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-country/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Country> province = provinceService.findById(id);
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
        provinceService.save(country);
        ModelAndView modelAndView = new ModelAndView("/country/edit");
        modelAndView.addObject("country", country);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-country/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Country> province = provinceService.findById(id);
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
        provinceService.remove(country.getId());
        return "redirect:provinces";
    }
}