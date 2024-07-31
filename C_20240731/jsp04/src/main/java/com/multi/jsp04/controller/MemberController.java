package com.multi.jsp04.controller;

import com.multi.jsp04.dao.MemberDAO;
import com.multi.jsp04.vo.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberController {
    private MemberDAO memberDAO = new MemberDAO();

    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            MemberVO member = new MemberVO();
            member.setId(request.getParameter("id"));
            member.setPassword(request.getParameter("password"));
            member.setName(request.getParameter("name"));
            memberDAO.insertMember(member);
            request.setAttribute("member", member);
            RequestDispatcher rd = request.getRequestDispatcher("views/member_result.jsp");
            rd.forward(request, response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            String id = request.getParameter("id");
            memberDAO.deleteMember(id);
            request.setAttribute("member_id", id);
            RequestDispatcher rd = request.getRequestDispatcher("views/member_result.jsp");
            rd.forward(request, response);
        }
    }