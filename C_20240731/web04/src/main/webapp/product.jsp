<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>상품 정보 페이지</title>
</head>
<body>
<h2>Add Product</h2>
<form action="/add_product" method="post">
    Product ID : <input type="text" name="id"/><br/>
    Name : <input type="text" name="name"/><br/>
    Price : <input type="text" name="price"/><br/>
    <input type="submit" value="Add"/>
</form>
<br/>
<h2>Delete Product</h2>
<form action="/delete_product" method="post">
    Product ID : <input type="text" name="id"/><br/>
    <input type="submit" value="Delete"/>
</form>
</body>
</html>