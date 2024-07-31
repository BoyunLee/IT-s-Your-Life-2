<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>고객 정보 페이지</title>
</head>
<body>
<h2>Add Customer</h2>
<form action="/add_customer" method="post">
    Customer ID : <input type="text" name="id"/><br/>
    Name : <input type="text" name="name"/><br/>
    Email : <input type="email" name="email"/><br/>
    <input type="submit" value="Add"/>
</form>
<br/>
<h2>Delete Customer</h2>
<form action="/delete_customer" method="post">
    Customer ID : <input type="text" name="id"/><br/>
    <input type="submit" value="Delete"/>
</form>
</body>
</html>
