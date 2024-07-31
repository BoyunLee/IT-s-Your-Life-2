package com.multi.jsp04.controller;

import com.multi.jsp04.dao.BoardDAO;
import com.multi.jsp04.vo.BoardVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardController {

    private BoardDAO boardDAO = new BoardDAO();

    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BoardVO board = new BoardVO();
        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        boardDAO.insertBoard(board);
        request.setAttribute("board", board);
        RequestDispatcher rd = request.getRequestDispatcher("views/board_result.jsp");
        rd.forward(request, response);
    }
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        boardDAO.deleteBoard(id);
        request.setAttribute("board_id", id);
        RequestDispatcher rd = request.getRequestDispatcher("views/board_result.jsp");
        rd.forward(request, response);
        }
    }
