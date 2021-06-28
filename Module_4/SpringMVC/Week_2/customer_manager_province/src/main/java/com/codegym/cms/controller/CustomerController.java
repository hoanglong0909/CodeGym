package com.codegym.cms.controller;

import com.codegym.cms.model.Country;
import com.codegym.cms.model.Customer;
import com.codegym.cms.service.customer.ICustomerService;
import com.codegym.cms.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("country")
    public Iterable<Country> provinces() {
        return provinceService.findAll();
    }

    @ModelAttribute("customers")
    public Customer customer(){
        return new Customer();
    }

    @GetMapping
    public ResponseEntity<Iterable<Customer>> allPhones() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createSmartphone(@RequestBody Customer customer ) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }




    @GetMapping("/list")
    public ModelAndView listCustomers(Pageable pageable) {
        Iterable<Customer> customers = customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customer",new Customer());
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteSmartphone(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }



}