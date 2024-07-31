package com.example.jsp03;

import com.example.jsp03.user.UserDAO;
import com.example.jsp03.user.UserVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    private String message;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        // 2. DB 연동 처리
        UserVO vo = new UserVO();
        vo.setId(id);

        UserDAO dao = new UserDAO();
        UserVO user = dao.getUser(vo);
        System.out.println(user);

        // 3. 응답 화면 구성
        // 응답 메시지에 대한 인코딩 설정
        response.setContentType("text/html;charset=UTF-8");
        // HTTP 응답 프로토콜 message-body와 연결된 출력 스트림 획득
        PrintWriter out = response.getWriter();

        // 메시지 출력
        if (user != null) {
            if (user.getPassword().equals(password)) {
//				// 상태 정보를 쿠키에 저장하여 전송한다.
//				Cookie userId = new Cookie("userId", user.getId());
//				response.addCookie(userId);

                // 상태 정보를 세션에 저장한다.
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(10);
                session.setAttribute("userId", user.getId());
                session.setAttribute("userName", user.getName());
                session.setAttribute("userRole", user.getRole());

                out.println("<h1>로그인 성공</h1>");
                out.println("<a href='logout.do'>로그아웃</a>");

            } else {
                out.println("비밀번호 오류입니다.<br>");
                out.println("<a href='login.jsp'>다시 로그인</a>");
            }
        } else {
            out.println("아이디 오류입니다.<br>");
            out.println("<a href='login.jsp'>다시 로그인</a>");
        }

    }
    }