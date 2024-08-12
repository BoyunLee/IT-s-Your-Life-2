package org.example.spring0000.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home() {
        //요청 처리할 수 있는 service호출
        //요청의 결과가 있다. --> jsp지정
        log.info("home controller index-----------------------");
        return "index"; // WEB-IBF/views/index.jsp
    }

    @GetMapping("/member")
    public String member() {
        //요청 처리할 수 있는 service호출
        //요청의 결과가 있다. --> jsp지정
        log.info("home controller member-----------------------");
        return "member"; // WEB-IBF/views/member.jsp
    }
}
