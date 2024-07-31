package com.example.jsp02;

import com.example.jsp02.db.UserDAO;
import com.example.jsp02.db.UserVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/listUser.do")
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String encoding;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDAO dao = new UserDAO();
		List<UserVO> list = dao.getUserList();

		// 2. 응답 화면 구성
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>회원 목록</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>회원 목록</h1>");

		out.println("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
		out.println("<tr>");
		out.println("<th bgcolor='orange' width='100'>아이디</th>");
		out.println("<th bgcolor='orange' width='200'>패스워드</th>");
		out.println("<th bgcolor='orange' width='150'>이름</th>");
		out.println("<th bgcolor='orange' width='150'>역할</th>");
		out.println("</tr>");


		for (UserVO userVO : list) {
			out.println("<tr>");
			out.println("<td>" + userVO.getId() + "</td>");
			out.println("<td>" + userVO.getPassword() + "</td>");
			out.println("<td>" + userVO.getName() + "</td>");
			out.println("<td>" + userVO.getRole() + "</td>");
			out.println("</tr>");
		}


		out.println("</table>");
		out.println("<br>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

}

