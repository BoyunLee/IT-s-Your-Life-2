<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>장바구니</title>
</head>
<body>
<h2>장바구니</h2>
<ul>
    <%
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (!cookie.getName().equals("JSESSIONID")) {
                    out.println("<li>" + cookie.getValue() + "</li>");
                }
            }
        } else {
            out.println("<li>장바구니가 비어 있습니다.</li>");
        }
    %>
</ul>
<a href="cart.jsp">아이템 추가</a>
</body>
</html>
