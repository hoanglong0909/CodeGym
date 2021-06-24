package com.manager.controller;

import com.manager.model.City;
import com.manager.service.city.CityService;
import com.manager.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CityController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CityService cityService;

    @GetMapping("/city")
    public ModelAndView listCity() {
        Iterable<City> cities = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("city", cities);
        return modelAndView;
    }

    @GetMapping("/city-create")
    public ModelAndView createCustomer() {
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/city-create")
    public ModelAndView showCreateCustomer(@ModelAttribute("city") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "New province created successfully");
        return modelAndView;
    }


    @GetMapping("/city-edit/{id}")
    public ModelAndView showEditCustomer(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/city/edit");
            modelAndView.addObject("city", city.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("erorr.404");
            return modelAndView;
        }
    }

    @PostMapping("/city-edit")
    public ModelAndView editCity(@ModelAttribute("city") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "Province updated successfully");
        return modelAndView;
    }

    @GetMapping("/city-delete/{id}")
    public ModelAndView deleteCity(@PathVariable("id") Long id) {
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/city/delete");
            modelAndView.addObject("city", city.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("erorr.404");
            return modelAndView;
        }
    }

    @PostMapping("/city-delete")
    public String deleteProvince(@ModelAttribute("city") City city) {
        cityService.remove(city.getId());
        return "redirect:city";
    }
}
