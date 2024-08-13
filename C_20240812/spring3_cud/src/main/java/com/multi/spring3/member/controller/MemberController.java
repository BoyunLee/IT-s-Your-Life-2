package com.multi.spring3.member.controller;

import com.multi.spring3.member.domain.MemberVO;
import com.multi.spring3.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/member")
 public class MemberController {

        private final MemberService memberService;


        @Autowired
        public MemberController(MemberService memberService) {
            System.out.println("MemberController created");
            this.memberService = memberService;
        }

        @GetMapping
        public String index() {
            return "member/member";
       }

        @PostMapping("/insert")
        public ModelAndView insert(MemberVO memberVO) {
            System.out.println(memberVO);
            String result = memberService.insert(memberVO);
            System.out.println("--------->> " + result);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("result", result);
            modelAndView.setViewName("member/insert_result");
            return modelAndView;
        }

        @PostMapping("/update")
        public ModelAndView update(MemberVO memberVO) {
            String result = memberService.update(memberVO);
            System.out.println("--------->> " + result);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("result", result);
            modelAndView.setViewName("member/update_result");
            return modelAndView;
        }

        @GetMapping("/login")
        public String login() {
           return "member/login";
        }

        @GetMapping("/logout")
        public String logout(HttpSession session) {
            //세션끊기
            session.invalidate();
            return "redirect:/";
        }

        @PostMapping("/loginProcess")
        public String loginProcess(MemberVO memberVO, HttpSession session) {
            int result = memberService.login(memberVO);
            System.out.println("--------->> " + result);
            if (result == 1){
                session.setAttribute("login_id", memberVO.getId());
                return "member/login_ok";
            }else{
                return "member/login_no";
            }
        }

        @PostMapping("/delete")
        public ModelAndView delete(@RequestParam("id") String id) {
            String result = memberService.delete(id);
            System.out.println("--------->> " + result);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("result", result);
            modelAndView.setViewName("member/delete_result");
            return modelAndView;
        }

        @GetMapping("/one")
        public ModelAndView one(String id) {
            MemberVO memberVO = memberService.one(id);
            System.out.println("--------->> " + memberVO);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("memberVO", memberVO);
            modelAndView.setViewName("member/one_result");
            return modelAndView;
        }

        @GetMapping("/all")
        public ModelAndView all() {
            List<MemberVO> all = memberService.all();
            System.out.println("--------->> " + all);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("all", all);
            modelAndView.setViewName("member/all_result");
            return modelAndView;
        }

        @GetMapping("/find")
        public ModelAndView find(@RequestParam("word") String word) {
            List<MemberVO> all = memberService.find(word);
            System.out.println("--------->> " + all);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("all", all);
            modelAndView.setViewName("member/find_result");
            return modelAndView;
        }
    }