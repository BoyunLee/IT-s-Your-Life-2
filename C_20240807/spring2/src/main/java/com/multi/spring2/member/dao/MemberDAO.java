package com.multi.spring2.member.dao;

import com.multi.spring2.member.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class MemberDAO {
    // JDBC 관련 변수
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    // USERS 테이블 관련 SQL 명령어
    private String USER_LIST = "select * from member";
    private String USER_INFO = "select * from member where id = ?";
    private String USER_INSERT = "insert into member values(?, ?, ?, ?)";
    private String USER_UPDATE = "update member set tel = ? where id = ?";
    private String USER_DELETE = "delete from member where id = ?";


    // 회원 등록
    public int insert(MemberVO vo) {
        log.debug("MemberDAO insert");
        int result = 0;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_INSERT);
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPw());
            stmt.setString(3, vo.getName());
            stmt.setString(4, vo.getTel());
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
        return result;
    }


    // USERS 테이블 관련 CRUD 메소드
    // 회원 삭제
    public int delete(String id) {
        log.debug("MemberDAO delete");
        int result = 0;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_DELETE);
            stmt.setString(1, id);
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
        return result;
    }

    // 회원 수정
    public int update(MemberVO vo) {
        log.debug("MemberDAO update");
        int result = 0;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_UPDATE);
            stmt.setString(1, vo.getTel());
            stmt.setString(2, vo.getId());
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
        return result;
    }

    // 회원 목록 조회
    public List<MemberVO> all() {
        log.debug("MemberDAO all");
        List<MemberVO> all = new ArrayList<MemberVO>();
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_LIST);
            rs = stmt.executeQuery();
            while(rs.next()) {
                MemberVO user = new MemberVO();
                user.setId(rs.getString("id"));
                user.setPw(rs.getString("pw"));
                user.setName(rs.getString("name"));
                user.setTel(rs.getString("tel"));
                all.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return all;
    }

    // 회원 정보 조회
    public MemberVO one(String id) {
        log.debug("MemberDAO one");
        MemberVO memberVO = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_INFO);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            if(rs.next()) {
                memberVO = new MemberVO();
                memberVO.setId(rs.getString("id"));
                memberVO.setPw(rs.getString("pw"));
                memberVO.setName(rs.getString("name"));
                memberVO.setTel(rs.getString("tel"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return memberVO;
    }

}