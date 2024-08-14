package com.multi.spring2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
 public class RootController {

    public RootController(){
        System.out.println("RootController created");
    }

    @GetMapping("/")
    public String root() {
        log.info("RootController / called info -------------");
        //일반적인 정보 메시지
        //시스템이 시작되었을 때, 주요 구성 요소가 초기화되었을 때, 특정 작업이 성공적으로 완료되었을 때.
        log.debug("RootController / called debug -------------");
        //디버깅을 위한 상세한 메시지
        //변수 값 확인, 메서드 진입 및 종료, 조건문 평가 등.
        log.error("RootController / called error -------------");
        //오류 메시지
        //예외 발생, 중요한 기능 실패, 시스템 불안정성 등의 상황

        return "index";
    }
}