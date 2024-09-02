package com.multi.spring2.young.controller;

import com.multi.spring2.young.service.YoungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/young")
public class YoungController {

    private YoungService youngService;

    public YoungController(){
        System.out.println("YoungController created");
    }

    @Autowired
    public YoungController(YoungService youngService) {
        System.out.println("YoungController created");
        this.youngService = youngService;
    }

    @GetMapping
    public String young(){
        return "young/young";
    }

    @GetMapping("/insert")
    public String insert(){
        youngService.insert();
        return "young/insert";
    }
}