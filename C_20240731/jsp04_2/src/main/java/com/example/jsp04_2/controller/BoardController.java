package com.example.jsp04_2.controller;

import com.example.jsp04_2.dao.BoardDAO;
import com.example.jsp04_2.vo.BoardVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardController {
    private BoardDAO boardDAO = new BoardDAO();

    public void insert(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        System.out.println("board insert 처리 요청 받음");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        BoardVO boardVO = new BoardVO();
        boardVO.setTitle(title);
        boardVO.setContent(content);
        boardDAO.insertBoard(boardVO);

        // 3. 응답 부분
        // --> forward
        request.setAttribute("board", boardVO); // 전달할 데이터 설정

        // 응답(jsp)
        // 결과를 담을 페이지 지정
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/board_result.jsp");
        dispatcher.forward(request, response);

    }

    public void delete(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        System.out.println("board delete 처리 요청 받음");
        String id = request.getParameter("id");
        boardDAO.deleteBoard(id);

        // 3. 응답 부분
        // --> forward
        request.setAttribute("board_id", id); // 전달할 데이터 설정

        // 응답(jsp)
        // 결과를 담을 페이지 지정
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/board_result.jsp");
        dispatcher.forward(request, response);
    }
}
