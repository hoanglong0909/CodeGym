package com.paging.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
    @RequestMapping("/")
    public String page1(){
        return "/page1";
    }
    @RequestMapping("/redirect")
    public String page2(){
        return "redirect: page2";
    }
    @RequestMapping("/page2")
    public String page3(){
        return "/page2";
    }
    @RequestMapping("/redirect1")
    public String page4(){
        return "redirect: page1";
    }
    @RequestMapping("/page1")
    public String page5(){
        return "/page1";
    }
}
