package com.multi.jsp04.dao;

import com.multi.jsp04.vo.BoardVO;
import java.util.HashMap;
import java.util.Map;

public class BoardDAO {
    private Map<Integer, BoardVO> boards = new HashMap<>();
    private int nextId = 1;

    public void insertBoard(BoardVO board) {
        board.setId(nextId++);
        boards.put(board.getId(), board);
    }

    public void deleteBoard(int id) {
        boards.remove(id);
    }
}
