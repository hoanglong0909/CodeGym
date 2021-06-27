//package com.demo.controller;
//
//
//import com.demo.model.Category;
//import com.demo.service.category.CategoryService;
//import com.demo.service.smartphone.SmartphoneService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Optional;
//
//@Controller
//public class CategoryController {
//    @Autowired
//    CategoryService categoryService;
//
////    @Autowired
////    SmartphoneService smartphoneService;
//
//
//    @RequestMapping("/categorys")
//    public ModelAndView showCategory(){
//        Iterable<Category> categories = categoryService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/category/list");
//        modelAndView.addObject("categories",categories);
//        return modelAndView;
//    }
//
////
////    @GetMapping("/create-category")
////    public ModelAndView showCreateForm() {
////        ModelAndView modelAndView = new ModelAndView("/category/create");
////        modelAndView.addObject("category", new Category());
////        return modelAndView;
////    }
////
////    @PostMapping("/create-category")
////    public ModelAndView saveProvince(@ModelAttribute("province") Category category) {
////        categoryService.save(category);
////        ModelAndView modelAndView = new ModelAndView("/category/create");
////        modelAndView.addObject("category", new Category());
////        modelAndView.addObject("message", "New province created successfully");
////        return modelAndView;
////    }
////
////    @GetMapping("/edit-category/{id}")
////    public ModelAndView showEditForm(@PathVariable Long id) {
////        Optional<Category> category = categoryService.findById(id);
////        if (category.isPresent()) {
////            ModelAndView modelAndView = new ModelAndView("/category/edit");
////            modelAndView.addObject("category", category.get());
////            return modelAndView;
////        } else {
////            ModelAndView modelAndView = new ModelAndView("/error.404");
////            return modelAndView;
////        }
////    }
////
////    @PostMapping("/edit-category")
////    public ModelAndView updateProvince(@ModelAttribute("country") Category category) {
////        categoryService.save(category);
////        ModelAndView modelAndView = new ModelAndView("/category/edit");
////        modelAndView.addObject("category", category);
////        modelAndView.addObject("message", "Province updated successfully");
////        return modelAndView;
////    }
////
////    @GetMapping("/delete-category/{id}")
////    public ModelAndView showDeleteForm(@PathVariable Long id) {
////        Optional<Category> category = categoryService.findById(id);
////        if (category.isPresent()) {
////            ModelAndView modelAndView = new ModelAndView("/category/delete");
////            modelAndView.addObject("category", category.get());
////            return modelAndView;
////        } else {
////            ModelAndView modelAndView = new ModelAndView("/error.404");
////            return modelAndView;
////        }
////    }
////
////    @PostMapping("/delete-category")
////    public String deleteProvince(@ModelAttribute("category") Category category) {
////        categoryService.remove(category.getId());
////        return "redirect:categorys";
////    }
//
//
//}
