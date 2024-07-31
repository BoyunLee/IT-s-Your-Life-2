package com.example.jsp04_2.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private MemberController memberController = new MemberController();
    private BoardController boardController = new BoardController();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/member_insert")){
            System.out.println("member_insert");
            memberController.insert(req, resp);
        }else if (uri.equals("/member_delete")){
            System.out.println("member_delete");
            memberController.delete(req, resp);
        }else if (uri.equals("/board_insert")){
            System.out.println("board_insert");
            boardController.insert(req, resp);
        } else if (uri.equals("/board_delete")){
            System.out.println("board_delete");
            boardController.delete(req, resp);
        }
    }
}
