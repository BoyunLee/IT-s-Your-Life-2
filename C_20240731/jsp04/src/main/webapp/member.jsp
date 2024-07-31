<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Member Page</title>
</head>
<body>
<h2>Member Registration</h2>
<form action="/member_insert" method="post">
    ID: <input type="text" name="id"/><br/>
    Password: <input type="password" name="password"/><br/>
    Name: <input type="text" name="name"/><br/>
    <input type="submit" value="Register"/>
</form>

<h2>Member Deletion</h2>
<form action="/member_delete" method="post">
    ID: <input type="text" name="id"/><br/>
    <input type="submit" value="Delete"/>
</form>
</body>
</html>

