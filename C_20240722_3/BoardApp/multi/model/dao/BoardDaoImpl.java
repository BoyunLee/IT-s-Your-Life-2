package com.multi.model.dao;

import com.multi.model.bean.BoardDto;
import com.multi.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDao {
	private static BoardDao boardDao = new BoardDaoImpl();

	public static BoardDao getBoardDao() {
		return boardDao;
	}
	@Override
	public void registerArticle(BoardDto boardDto) {//
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con= DBUtil.getInstance().getConnection();
			StringBuilder sql=new StringBuilder("insert into board (subject,content,user_id) \n");
			con.setAutoCommit(false);
			sql.append("values (?,?,?)");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setString(3, boardDto.getUserId());
			if(pstmt.executeUpdate()>0){
				System.out.println("insert Success!");
				con.commit();			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				con.rollback();				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}finally {
			DBUtil.getInstance().close(pstmt,con);
		}
	}

	@Override
	public List<BoardDto> searchListAll() {//전체 List
		// TODO Auto-generated method stub
		List<BoardDto>list=new ArrayList<BoardDto>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;		
		try {
			con=DBUtil.getInstance().getConnection();
			StringBuilder sql=new StringBuilder("SELECT ARTICLE_NO ,USER_ID,SUBJECT,CONTENT,REGISTER_TIME \n");
			sql.append("FROM BOARD \n")
			.append("ORDER BY ARTICLE_NO DESC");
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();//결과집합
			//ARTICLE_NO,USER_ID,SUBJECT,CONTENT,REGISTER_TIME
			//    1       bit    aaa      cc     2023-0410  
            //    2       bit    bbb      d      2023-0410 
			while(rs.next()) {
				BoardDto dto=new BoardDto();
				dto.setArticleNo(rs.getInt("ARTICLE_NO"));
				dto.setUserId(rs.getString("USER_ID"));
				dto.setSubject(rs.getString("SUBJECT"));
				dto.setContent(rs.getString("CONTENT"));
				dto.setRegisterTime(rs.getString("REGISTER_TIME"));
				list.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.getInstance().close(rs,pstmt,con);
		}
		return list;
	}

	@Override
	public List<BoardDto> searchListBySubject(String subject) {
		// TODO Auto-generated method stub
		List<BoardDto> list = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("select article_no , subject , content, user_id, register_time \n");
			sql.append("from board \n");
			sql.append("where subject like ? \n");
			sql.append("order by article_no desc");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + subject + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setRegisterTime(rs.getString("register_time"));
				list.add(boardDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public BoardDto viewArticle(int no) {//상세정보 
		// TODO Auto-generated method stub
		BoardDto boardDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("select article_no, subject, content, user_id, register_time \n");
			sql.append("from board \n");
			sql.append("where article_no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boardDto = new BoardDto();
				boardDto.setArticleNo(rs.getInt("article_no"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setUserId(rs.getString("user_id"));
				boardDto.setRegisterTime(rs.getString("register_time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, pstmt, conn);
		}
		return boardDto;
	}

	@Override
	public void modifyArticle(BoardDto boardDto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			conn.setAutoCommit(false);
			StringBuilder sql = new StringBuilder("update board \n");
			sql.append("set subject = ?, content = ? \n");
			sql.append("where article_no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, boardDto.getSubject());
			pstmt.setString(2, boardDto.getContent());
			pstmt.setInt(3, boardDto.getArticleNo());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DBUtil.getInstance().close(pstmt, conn);
		}
	}

	@Override
	public void deleteArticle(int no) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			conn.setAutoCommit(false);
			StringBuilder sql = new StringBuilder("delete from board \n");
			sql.append("where article_no = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			DBUtil.getInstance().close(pstmt, conn);
		}
	}
}
