package com.multi.spring2.aop.controller;

import com.multi.spring2.aop.domain.BoardVO;
import com.multi.spring2.aop.domain.MemberVO;
import com.multi.spring2.aop.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AOPController {

    ASiteInterface aSiteService;
    TransactionInterface aopService;


    @Autowired
    public AOPController(ASiteInterface aSiteService, TransactionService aopService) {
        this.aSiteService = aSiteService;
        this.aopService = aopService;
    }

    @RequestMapping("a.do")
    public void aop1() {
        aSiteService.tour();
    }

    @RequestMapping("a2.do")
    public void aop2() {
        aSiteService.order();
    }

    @RequestMapping("a3.do")
    public void aop3() {
        aSiteService.anotherTask();
        aSiteService.performTask();
        aSiteService.anotherTask();
        aSiteService.performTask();
    }

    @RequestMapping("transaction.do")
    public String transaction(BoardVO bbsVO2,
                              MemberVO memberVO,
                              Model model) {
        int result = 0;
        try {
            result = aopService.tran(bbsVO2, memberVO);
            model.addAttribute("result", "모든 db처리 성공!! commit중");
        } catch (Exception e) {
            model.addAttribute("result", "db처리 에러발생!!! rollback중");
            e.printStackTrace();
        }

        System.out.println("result: " + result);

        return "/aop/aop_result";
    }

}
