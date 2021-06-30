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

    @ModelAttribute("countrys")
    public Iterable<Country> provinces() {
        return provinceService.findAll();
    }

//    @ModelAttribute("customers")
//    public Customer customer(){
//        return new Customer();
//    }

    @GetMapping
    public ResponseEntity<Iterable<Customer>> allPhones() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createSmartphone(@RequestBody Customer customer ) {
        customer.getCountry().setName(provinceService.findById(customer.getCountry().getId()).get().getName());
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

    @GetMapping("/edit-customer/{id}")
    public ResponseEntity<Customer> customerResponseEntity(@PathVariable Long id){
        Customer customerOptional = customerService.findById(id).get();
        return new ResponseEntity<>(customerOptional,HttpStatus.OK);
    }

}