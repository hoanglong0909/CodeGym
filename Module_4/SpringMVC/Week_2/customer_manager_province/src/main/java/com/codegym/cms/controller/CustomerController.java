package com.codegym.cms.controller;

import com.codegym.cms.model.Country;
import com.codegym.cms.model.Customer;
import com.codegym.cms.service.customer.ICustomerService;
import com.codegym.cms.service.country.IProvinceCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceCountry countryService;

    @ModelAttribute("countrys")
    public Iterable<Country> country() {
        return countryService.findAll();
    }

    @GetMapping
    public ResponseEntity<Iterable<Customer>> AllCustomer() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer ) {
        customer.getCountry().setName(countryService.findById(customer.getCountry().getId()).get().getName());
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView listCustomers() {
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers",customerService.findAllByOrderByIdDesc());
        return modelAndView;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteSmartphone(@PathVariable long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        customerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }


    @PostMapping("/edit/{id}")
    public ResponseEntity<Customer> customerResponseEntity(@RequestBody Customer customer,@PathVariable Long id){
        customer.setId(id);
        customer.getCountry().setName(countryService.findById(customer.getCountry().getId()).get().getName());
        return new ResponseEntity<>(customerService.save(customer),HttpStatus.OK);
    }


    @GetMapping("/api/{id}")
    public ResponseEntity<Customer> showApi(@PathVariable long id){
        Optional<Customer> optional = customerService.findById(id);
        return new ResponseEntity<>(optional.get(),HttpStatus.OK);
    }


}