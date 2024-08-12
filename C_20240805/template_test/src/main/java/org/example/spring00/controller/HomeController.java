package org.example.spring00.controller;

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

    @GetMapping("/test")
    public String home() {
        log.info("================> HomeController test/");
        return "test"; // View의 이름
    }

    @GetMapping("/member")
    public String member() {
        log.info("================> HomeController member/");
        return "member"; // View의 이름
    }
}
