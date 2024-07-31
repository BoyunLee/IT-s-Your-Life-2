package com.multi.mvc04.web04.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private CustomerController customerController = new CustomerController();
    private ProductController productController = new ProductController();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/add_customer")){
            System.out.println("add_customer");
            customerController.add(req, resp);
        }else if (uri.equals("/delete_customer")){
            System.out.println("delete_customer");
            customerController.delete(req, resp);
        }else if (uri.equals("/add_product")){
            System.out.println("add_product");
            productController.add(req, resp);
        } else if (uri.equals("/delete_product")){
            System.out.println("delete_product");
            productController.delete(req, resp);
        }
    }
}