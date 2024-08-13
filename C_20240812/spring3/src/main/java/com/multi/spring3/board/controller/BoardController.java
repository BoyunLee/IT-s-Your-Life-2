package com.multi.spring3.board.controller;

import com.multi.spring3.member.domain.MemberVO;
import com.multi.spring3.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
 public class BoardController {

 @RequestMapping
 public String boardHome() {
  return "board/board";
 }
}