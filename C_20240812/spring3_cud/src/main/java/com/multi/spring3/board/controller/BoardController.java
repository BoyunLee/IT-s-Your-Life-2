package com.multi.spring3.board.controller;

import com.multi.spring3.board.service.BoardService;
import com.multi.spring3.board.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/board")
 public class BoardController {

 private final BoardService boardService;

 @Autowired
 public BoardController(BoardService boardService) {
      System.out.println("BoardController created");
      this.boardService = boardService;
 }

 @GetMapping
 public String index() {
  return "board/board";
 }

 @GetMapping("/insert")
 public ModelAndView insert(BoardVO boardVO) {
  System.out.println(boardVO);
  String result = boardService.insert(boardVO);
  System.out.println("--------->> " + result);
  ModelAndView modelAndView = new ModelAndView();
  modelAndView.addObject("result", result);
  modelAndView.setViewName("board/insert_result");
  return modelAndView;
 }

 @PostMapping("/update")
 public ModelAndView update(BoardVO boardVO) {
  String result = boardService.update(boardVO);
  System.out.println("--------->> " + result);
  ModelAndView modelAndView = new ModelAndView();
  modelAndView.addObject("result", result);
  modelAndView.setViewName("board/update_result");
  return modelAndView;
 }

 @GetMapping("/delete")
 public ModelAndView delete(@RequestParam("no") int no) {
  String result = boardService.delete(no);
  System.out.println("--------->> " + result);
  ModelAndView modelAndView = new ModelAndView();
  modelAndView.addObject("result", result);
  modelAndView.setViewName("board/delete_result");
  return modelAndView;
 }

 @GetMapping("/one")
 public ModelAndView one(int no) {
  BoardVO boardVO = boardService.one(no);
  System.out.println("--------->> " + boardVO);
  ModelAndView modelAndView = new ModelAndView();
  modelAndView.addObject("boardVO", boardVO);
  modelAndView.setViewName("board/one_result");
  return modelAndView;
 }

 @GetMapping("/all")
 public ModelAndView all() {
  List<BoardVO> all = boardService.all();
  System.out.println("--------->> " + all);
  ModelAndView modelAndView = new ModelAndView();
  modelAndView.addObject("all", all);
  modelAndView.setViewName("board/all_result");
  return modelAndView;
 }
}
