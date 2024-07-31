<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상품 정보 처리 결과 페이지</title>
</head>
<body>
추가 요청한 상품 정보 : <%= request.getAttribute("product") %><br>
삭제 요청한 상품 아이디 : <%= request.getAttribute("product_id") %>
</body>
</html>
