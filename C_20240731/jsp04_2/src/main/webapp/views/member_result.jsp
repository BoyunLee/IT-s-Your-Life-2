<%@ page import="com.example.jsp04_2.vo.MemberVO" %>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>회원정보 처리 결과를 담는 페이지</title>
</head>
<body>
회원가입한 정보 : <%= request.getAttribute("member")%>
<%--<hr>--%>
<%--<% MemberVO memberVO = (MemberVO) request.getAttribute("member"); %>--%>
<%--회원가입한 이름은 <%= memberVO.getName() %> <br>--%>
<%--회원가입한 아이디는 <%= memberVO.getId() %> <br>--%>
<%--${memberVO}, ${memberVO.id}--%>
<hr color="blue">
삭제 요청한 아이디 : <%= request.getAttribute("member_id") %><br>
<%--${member_id}--%>
</body>
</html>
