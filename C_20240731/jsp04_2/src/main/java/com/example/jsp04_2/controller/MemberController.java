package com.example.jsp04_2.controller;

import com.example.jsp04_2.dao.MemberDAO;
import com.example.jsp04_2.vo.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
public class MemberController {
    MemberDAO memberDAO = new MemberDAO();

    //insert요청
    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        System.out.println("memebr_insert 처리 요청 받음.");
        // 1. 전달된 데이터를 받으세요.
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        System.out.println(name + " " + id + " " + password);

        // 2. dao의 메서드 호출
        MemberVO vo = new MemberVO();
        vo.setName(name);
        vo.setId(id);
        vo.setPassword(password);

        memberDAO.insertMember(vo);

        // 3. 응답 부분
        // --> forward
        request.setAttribute("member", vo); // 전달할 데이터 설정

        // 응답(jsp)
        // 결과를 담을 페이지 지정
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/member_result.jsp");
        dispatcher.forward(request, response);
    }
    //delete요청
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String id = request.getParameter("id");
        System.out.println(id);
        //dao의 서드 호출
        memberDAO.deleteMember(id);
        request.setAttribute("member_id", id);

        // 응답(jsp)
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/member_result.jsp");
        dispatcher.forward(request, response);
    }
}