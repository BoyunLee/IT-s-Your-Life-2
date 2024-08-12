package com.multi.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
 public class RootController {

    public RootController(){
        System.out.println("RootController created");
    }

    @GetMapping("/")
    public String root(){
        return "index";
    }
}