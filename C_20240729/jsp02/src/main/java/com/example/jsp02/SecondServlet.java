package com.example.jsp02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get요청 들어옴.");
        String name = req.getParameter("name");
        System.out.println("서버에서 받은 name은 " + name);
        String choice = req.getParameter("choice");
        System.out.println("서버에서 받은 choice는 " + choice);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post요청 들어옴.");
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        System.out.println("서버에서 받은 id는 " + id);
        String pw = req.getParameter("pw");
        System.out.println("서버에서 받은 pw는 " + pw);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><body>success<br>");
        out.print("last time<br>나는 한글이란다</body></html>");
        out.close();
    }
}
