package com.example.win00.controller;

import com.example.win00.domain.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class BoardController {
    @GetMapping("/insert")
    public String insert(int no, String title, String content, String writer) {
        log.info("================> BoardController insert/");
        System.out.println("컨트롤러에서 받은 데이터 : " + no + ", " + title + ", " + content + ", " + writer);
        return "insert";
    }

    @GetMapping("/delete")
    public String delete(int no) {
        log.info("================> BoardController delete/");
        System.out.println("컨트롤러에서 받은 데이터 : " + no);
        return "delete";
    }

    @PostMapping("/one")
    // public String one(int no, Model model) {
    public ModelAndView one(int no) {
        log.info("================> BoardController one/");

        BoardVO boardVO = new BoardVO();
        boardVO.setNo(no);
        boardVO.setTitle("fun");
        boardVO.setContent("fun");
        boardVO.setWriter("apple");

        log.info("boardVO : " + boardVO);

        ModelAndView mv = new ModelAndView();
        mv.addObject("boardVO", boardVO);
        mv.setViewName("one");

        return mv;

        /*model.addAttribute("board", boardVO);
        return "one";*/
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET) //선택가능
    public String update(@RequestParam("no") int no, @RequestParam("title") String title) {
        log.info("===============> BoardController update/");
        System.out.println("컨트롤러에서 받은 데이터 : " + no + ", " + title);
        return "redirect:/";
    }
}

