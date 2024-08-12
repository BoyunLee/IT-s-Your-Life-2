package com.multi.win01.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String index() {
        log.info("================> HomeController index/");
        return "index"; // View의 이름
    }

   @GetMapping("/finance")
    public String finance() {
        log.info("===============> HomeController finance/");
        return "finance";
   }
}
