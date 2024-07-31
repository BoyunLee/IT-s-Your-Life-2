package com.multi.mvc04.web04.controller;

import com.multi.mvc04.web04.dao.ProductDAO;
import com.multi.mvc04.web04.vo.ProductVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductController {
    ProductDAO productDAO = new ProductDAO();

    public void add(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        System.out.println("product_add 처리 요청 받음");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        System.out.println(id + " " + name + " " + price);

        ProductVO vo = new ProductVO();
        vo.setId(id);
        vo.setName(name);
        vo.setPrice(price);

        productDAO.addProduct(vo);

        req.setAttribute("product", vo);

        RequestDispatcher dispatcher = req.getRequestDispatcher("views/product_result.jsp");
        dispatcher.forward(req, res);
    }

    public void delete(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String id = req.getParameter("id");
        System.out.println(id);

        productDAO.delectProduct(id);
        req.setAttribute("product_id", id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("views/product_result.jsp");
        dispatcher.forward(req, res);
    }
}
