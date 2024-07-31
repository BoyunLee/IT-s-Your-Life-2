<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%
    // request 객체를 통해 사용자 입력 데이터 가져오기
    String username = request.getParameter("username");

    // 세션에 사용자 이름 저장
    session.setAttribute("username", username);

    // 애플리케이션 컨텍스트에 현재 시간 저장
    application.setAttribute("currentTime", new Date());

    // pageContext를 통해 세션에서 사용자 이름 가져오기
    String sessionUsername = (String) pageContext.getAttribute("username", PageContext.SESSION_SCOPE);

    // pageContext를 통해 애플리케이션에서 현재 시간 가져오기
    Date currentTime = (Date) pageContext.getAttribute("currentTime",
            PageContext.APPLICATION_SCOPE);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Process Page</title>
</head>
<body>
<h2>Processed Data</h2>
<p>Hello, <%= sessionUsername %>!</p>
<p>Current Time: <%= currentTime %></p>
<p><a href="index.jsp">Go Back</a></p>
</body>
</html>
