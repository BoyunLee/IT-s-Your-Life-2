package com.example.jsp02.db;

import java.sql.ResultSet;
import java.util.List;

public class InsertUserTest {

	public static void main(String[] args) {
		// 1. UserDAO 객체를 생성한다.
		UserDAO dao = new UserDAO();
		
		// 2. 회원 정보를 등록한다. 
		UserVO vo = new UserVO();		
		vo.setName("win");
		vo.setRole("user");
		vo.setId("win");
		vo.setPassword("1234");
		dao.insertUser(vo);
		
		// 3. 목록을 조회한다. 
		List<UserVO> list =  dao.getUserList();
		for (UserVO vo2: list ){
			System.out.println(vo2);
		}
	}
}


