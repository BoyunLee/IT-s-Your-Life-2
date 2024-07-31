<%@ page import="com.example.jsp03.cart.Item" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>장바구니 예제</title>
</head>
<body>
<h1>상품 목록</h1>
<form action="CartServlet" method="post">
    <input type="hidden" name="itemName" value="product1">
    <input type="hidden" name="itemPrice" value="10000">
    <button type="submit">상품1 추가 (₩10,000)</button>
</form>
<form action="CartServlet" method="post">
    <input type="hidden" name="itemName" value="product2">
    <input type="hidden" name="itemPrice" value="20000">
    <button type="submit">상품2 추가 (₩20,000)</button>
</form>

<hr color="red">
<h3>장바구니</h3>
<ul>
<%
    if(session.getAttribute("cart") != null){
        List<Item> list = (List<Item>) session.getAttribute("cart");

            for (Item item: list){
                out.print("<li>" + item.getName() + "- " + item.getPrice());
            }
    }else {
        out.print("<li>장바구니가 비어있습니다.</li>");
    }
%>
</ul>
</body>
</html>
