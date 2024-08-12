package org.example.spring0000.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.spring0000.domain.HomeVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class MemberController {

    @GetMapping("/insert")
    public String insert(@RequestParam("id") int id, String name) {
        log.info(id + " " + name + ">> memberController insert ---");
        return "insert";
    }

    @GetMapping("/delete")
    public String delete() {
        log.info("memberController delete ---");
        return "delete";
    }

    @GetMapping("/update")
    public String update() {
        log.info("memberController update ---");
        return "update";//
    }

    @PostMapping("/one")
    public ModelAndView one(@RequestParam("id") int id, Model model) { //id파라메터 서버에서 받는 연습
        log.info("memberController one ---");
        HomeVO homeVO = new HomeVO();
        homeVO.setId(id);
        homeVO.setName("hong");
        ModelAndView modelAndView = new ModelAndView("one"); //뷰이름
        modelAndView.addObject("homeVO", homeVO);//전달한 데이터
        //modelAndView.setViewName("one");
        return modelAndView; //views파일에 결과 전달
        /*
        model.addAttribute("homeVO", homeVO);
        return "one";
        public String one()
         */
    }
}
