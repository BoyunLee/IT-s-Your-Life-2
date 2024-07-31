package com.example.jsp04_2.dao;

import com.example.jsp04_2.vo.BoardVO;

import java.util.HashMap;
import java.util.Map;

public class BoardDAO {
    Map<Integer, BoardVO> boards = new HashMap<Integer, BoardVO>();

    public void insertBoard(BoardVO board) {
        System.out.println("dao insert board >> " + board);
        boards.put(board.getId(), board);
    }

    public void deleteBoard(String id) {
        System.out.println("dao insert board >> " + id);
        boards.remove(id);
    }
}
