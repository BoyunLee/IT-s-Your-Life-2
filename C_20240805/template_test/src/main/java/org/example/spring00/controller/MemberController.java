package org.example.spring00.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.spring00.domain.HomeVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class MemberController {
    @GetMapping("/insert")
    public String insert() {
        log.info("================> MemberController insert/");
        return "insert"; // View의 이름
    }

    @GetMapping("/delete")
    public String delete() {
        log.info("================> MemberController delete/");
        return "delete"; // View의 이름
    }

    @PostMapping("one")
    public ModelAndView one(@RequestParam("id") int id) {
        log.info("================> MemberController one/");
        ModelAndView modelAndView = new ModelAndView("one");
        HomeVO homeVO = new HomeVO();
        homeVO.setId(id);
        homeVO.setName("hong");
        modelAndView.addObject("homeVO", homeVO);
        return modelAndView; // View의 이름
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET) //선택가능
    public String update(@RequestParam("id") int id, @RequestParam("name") String name) {
        log.info("================> MemberController update/");
        return "redirect:/";
    }
}

