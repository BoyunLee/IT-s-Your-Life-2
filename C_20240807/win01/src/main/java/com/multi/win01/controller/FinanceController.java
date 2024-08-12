package com.multi.win01.controller;

import com.multi.win01.domain.FinanceVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class FinanceController {

    @GetMapping("/economy")
    public ModelAndView economy() {
        log.info("================> FinanceController economy/");

        List<String> news = new ArrayList<>();
        news.add("금리 결정 회의 앞둔 美日英");
        news.add("고위험·고수익 美 트렌드 추종");
        news.add("미국, 일본, 영국 '환율 슈퍼 위크'");

        // -------작성-----------
        ModelAndView modelAndView = new ModelAndView("economy");
        modelAndView.addObject("newsList", news);
        // ----------------------
        return modelAndView;
    }

    @GetMapping("/money")
    public ModelAndView money(int money) {
        log.info("================> FinanceController money/");

        String result = "현금 보유 필요";
        if (money <= 20000 && money > 10000) {
            result = "적금을 통해 현금 보유 증가";
        }else if (money <= 50000 && money > 20000){
            result = "공격성 상품 투자를 통해 수익 증가";
        }else if(money > 50000){
            result = "충분한 현금 보유";
        }
        // -------작성-----------
        ModelAndView modelAndView = new ModelAndView("money");
        modelAndView.addObject("result", result);
        // ----------------------
        return modelAndView;
    }

    @GetMapping("invest")
    public ModelAndView invest() {
        log.info("================> FinanceController invest/");

        FinanceVO financeVO = new FinanceVO();
        financeVO.setFinanceId(1);
        financeVO.setTitle("파생상품");
        financeVO.setContent("장기 미국 투자 파생상품");
        financeVO.setField("투자 상품");
        financeVO.setAmount(10000000);
        // -------작성-----------
        ModelAndView modelAndView = new ModelAndView("invest");
        modelAndView.addObject("finance", financeVO);
        // ----------------------

        return modelAndView;
    }

    @RequestMapping(value = "/stock", method = RequestMethod.GET) //선택가능
    public String stock() {
        log.info("================> FinanceController stock/");
        // -------작성-----------
        return "redirect:/";
        // ----------------------
    }
}

