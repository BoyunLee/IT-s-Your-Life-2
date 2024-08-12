package com.example.win00.controller;

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

    @GetMapping("/board")
    public String board() {
        log.info("================> HomeController board/");
        return "board"; // View의 이름
    }
}
