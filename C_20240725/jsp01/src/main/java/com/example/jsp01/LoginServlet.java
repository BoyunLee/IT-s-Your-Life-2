package com.example.jsp01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "loginProcess", value = "/loginProcess")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
        System.out.println("Login Servlet 객체 생성됨");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get 요청 들어옴");

        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        System.out.println("id : " + id + " pw : " + pw);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head></head>");
        out.println("<body>");
        out.println("<h1>id >> " + id + "pw>>" + pw + "</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post 요청 들어옴");


    }
}
