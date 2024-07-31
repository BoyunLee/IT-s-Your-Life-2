<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>장바구니 추가</title>
</head>
<body>
<%
    String item = request.getParameter("item");
    if (item != null && !item.trim().isEmpty()) {
        Cookie[] cookies = request.getCookies();
        boolean exists = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(item)) {
                    exists = true;
                    break;
                }
            }
        }

        if (!exists) {
            Cookie newItem = new Cookie(item, item);
            newItem.setMaxAge(60 * 60 * 24); // 1 day
            response.addCookie(newItem);
            out.println("<p>아이템 '" + item + "'이 장바구니에 추가되었습니다.</p>");
        } else {
            out.println("<p>아이템 '" + item + "'은(는) 이미 장바구니에 있습니다.</p>");
        }
    } else {
        out.println("<p>유효하지 않은 아이템입니다.</p>");
    }
%>
<a href="viewCart.jsp">장바구니 보기</a>
<a href="cart.jsp">아이템 추가</a>
</body>
</html>
