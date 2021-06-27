package com.demo.controller;


import com.demo.model.Customer;
import com.demo.service.Customer.ICustomerService;
import com.demo.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ICustomerService customerService;



    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Customer>> allCustomer() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ModelAndView getAllCustomer(){
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers",customerService.findAll());
        return  modelAndView;
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
//        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
//        if (!smartphoneOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        smartphoneService.remove(id);
//        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
//    }



//    @GetMapping
//    public ResponseEntity<Iterable<Smartphone>> allPhones() {
//        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
//        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
//    }



//    @GetMapping("/list")
//    public ModelAndView getAllSmartphonePage() {
//        ModelAndView modelAndView = new ModelAndView("/phones/list");
//        modelAndView.addObject("smartphones", smartphoneService.findAll());
//        return modelAndView;
//    }


//    @DeleteMapping("/{id}")
//    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
//        Optional<Smartphone> smartphoneOptional = smartphoneService.findById(id);
//        if (!smartphoneOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        smartphoneService.remove(id);
//        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
//    }

}