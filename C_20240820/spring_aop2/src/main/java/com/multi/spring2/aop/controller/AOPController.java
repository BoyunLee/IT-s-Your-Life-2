package com.multi.spring2.aop.controller;

import com.multi.spring2.aop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AOPController {

    ASiteInterface aSiteService;


    @Autowired
    public AOPController(ASiteInterface aSiteService) {
        this.aSiteService = aSiteService;
    }

    @RequestMapping("call.do")
    public void call() {
        aSiteService.task1();
        aSiteService.task1();
        aSiteService.task1();
        aSiteService.task1();
        aSiteService.task1();
        aSiteService.task2();
        aSiteService.task2();
        aSiteService.task2();
        aSiteService.task2();
        aSiteService.task2();
    }
}
