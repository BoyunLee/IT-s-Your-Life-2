package com.example.jsp03;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
    private String message;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //세션 객체 획득
        HttpSession session = request.getSession();
        session.invalidate();

        // 세션 해제 후 이동할 페이지 지정
        response.sendRedirect("login.jsp");
    }
}

