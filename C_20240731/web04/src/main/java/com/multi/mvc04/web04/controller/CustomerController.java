package com.multi.mvc04.web04.controller;

import com.multi.mvc04.web04.dao.CustomerDAO;
import com.multi.mvc04.web04.vo.CustomerVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerController {
    CustomerDAO customerDAO = new CustomerDAO();

    public void add(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        System.out.println("customer_add 처리 요청 받음");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        System.out.println(id + " " + name + " " + email);

        CustomerVO vo = new CustomerVO();
        vo.setId(id);
        vo.setName(name);
        vo.setEmail(email);

        customerDAO.addCustomer(vo);

        req.setAttribute("customer", vo);

        RequestDispatcher dispatcher = req.getRequestDispatcher("views/customer_result.jsp");
        dispatcher.forward(req, res);
    }

    public void delete(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String id = req.getParameter("id");
        System.out.println(id);

        customerDAO.delectCustomer(id);
        req.setAttribute("customer_id", id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("views/customer_result.jsp");
        dispatcher.forward(req, res);
    }
}
