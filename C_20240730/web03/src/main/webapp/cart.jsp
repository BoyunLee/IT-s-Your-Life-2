<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>장바구니</title>
</head>
<body>
<h2>추가할 아이템을 입력하세요.</h2>
<p>단, 동일한 물건을 장바구니에 넣을 수 없음.</p>
<p>(영문입력 가능, 띄어쓰기 없음)</p>
<form action="addCart.jsp" method="post">
    <input type="text" name="item" required>
    <input type="submit" value="장바구니 추가">
</form>
<a href="viewCart.jsp">장바구니 보기</a>
</body>
</html>
