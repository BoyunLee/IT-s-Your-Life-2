package com.multi.jsp04.controller;

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
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/member_insert")) {
            memberController.insert(request, response);
        } else if (uri.equals("/member_delete")) {
            memberController.delete(request, response);
        } else if (uri.equals("/board_insert")) {
            boardController.insert(request, response);
        } else if (uri.equals("/board_delete")) {
            boardController.delete(request, response);
        }
    }
}
