package com.example.jsp02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/check.do")
public class CheckServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get요청 들어옴.");
        String today = req.getParameter("today");
        String result = "그냥 있자";
        if (today.equals("맑음")){
            result = "나가자";
        } else  if (today.equals("흐림")){
            result = "코딩";
        } else if (today.equals("비움")){
            result = "쇼핑";
        }

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println(result);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post요청 들어옴.");
        req.setCharacterEncoding("UTF-8");
        String pass = req.getParameter("pass");
        String result = "들어올 수 없습니다. <img src='image/no.png'>";
        if (pass.equals("나는왕이다")){
            result = "들어오세요. <img src='image/yes.png'>";
        }
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("<h3>" + result +"</h3>");
        out.print("</body></html>");
        out.close();
    }
}
