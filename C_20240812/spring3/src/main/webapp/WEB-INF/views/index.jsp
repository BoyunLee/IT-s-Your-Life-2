<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring</title>
    <link rel="stylesheet" href="resources/css/out.css">
</head>
<body>
<h1></h1>
<br/>
<table>
    <tbody>
    <tr>
        <td style="background: lemonchiffon; text-align: center">
            <a href="member/login">
                <button>로그인 처리</button>
            </a>
        </td>
    </tr>
    <tr>
        <td style="background: lemonchiffon; text-align: center">
          <form action="member/find" method="get">
              find id : <input type="text" name="word" value="1">
              <button>id 포함 검색</button>
          </form>
        </td>
    </tr>
    <tr>
        <td style="background: lemonchiffon; text-align: center">
            <a href="member">
                <button>회원정보 처리</button>
            </a>
        </td>
    </tr>
    <tr>
        <td style="background: lemonchiffon; text-align: center">
            <a href="board"><button>게시판정보 처리</button></a><br>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>