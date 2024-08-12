package com.multi.spring2.board.dao;

import com.multi.spring2.board.domain.BoardVO;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDAO {
    // JDBC 관련 변수
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // BOARD 테이블 관련 SQL 명령어
    private String BOARD_LIST = "select * from board";
    private String BOARD_INFO = "select * from board where no = ?";
    private String BOARD_INSERT = "insert into board values(null, ?, ?, ?)";
    private String BOARD_UPDATE = "update board set title = ? where no = ?";
    private String BOARD_DELETE = "delete from board where no = ?";

    // board 테이블 관련 CRUD 메소드
    // 게시물 삭제
    public int delete(int no) {
        int result = 0;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_DELETE);
            stmt.setInt(1, no);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
        return result;
    }

    //수정
    public int update(BoardVO vo) {
        int result = 0;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_UPDATE);
            stmt.setString(1, vo.getTitle());
            stmt.setInt(2, vo.getNo());
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
        return result;
    }



    // 등록
    public int insert(BoardVO vo) {
        int result = 0;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_INSERT);
            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getContent());
            stmt.setString(3, vo.getWriter());
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
        return result;
    }

    // 목록 조회
    public List<BoardVO> all() {
        List<BoardVO> all = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_LIST);
            rs = stmt.executeQuery();
            while(rs.next()) {
                BoardVO vo = new BoardVO();
                vo.setNo(rs.getInt("no"));
                vo.setTitle(rs.getString("title"));
                vo.setContent(rs.getString("content"));
                vo.setWriter(rs.getString("writer"));
                all.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return all;
    }

    // 조회
    public BoardVO one(int no) {
        BoardVO vo = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_INFO);
            stmt.setInt(1, no);
            rs = stmt.executeQuery();
            if(rs.next()) {
                vo = new BoardVO();
                vo.setNo(rs.getInt("no"));
                vo.setTitle(rs.getString("title"));
                vo.setContent(rs.getString("content"));
                vo.setWriter(rs.getString("writer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return vo;
    }
}

