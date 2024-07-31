<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Board Page</title>
</head>
<body>
<h2>Add Board</h2>
<form action="/board_insert" method="post">
    Title: <input type="text" name="title"/><br/>
    Content: <textarea name="content"></textarea><br/>
    <input type="submit" value="Add"/>
</form>

<h2>Delete Board</h2>
<form action="/board_delete" method="post">
    ID: <input type="text" name="id"/><br/>
    <input type="submit" value="Delete"/>
</form>
</body>
</html>
