<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html><head> <title>Member</title></head><body>
<h1>welcome spring world!</h1><br/>
<table border="1">
  <tr style="width: 400px;">
    <td style="background: yellow">회원가입</td>
    <td style="background: yellow">회원탈퇴</td>
    <td style="background: yellow">회원수정</td>
    <td style="background: yellow">회원정보</td>
  </tr>
  <tr>
    <td>
      <a href="insert?id=100&name=hong">
        <button>회원가입 처리 요청</button>
      </a>
    </td>
    <td>
      <a href="delete?id=100">
        <button>회원탈퇴 처리 요청</button>
      </a>
    </td>
    <td>
      <a href="update?id=100&name=hong">
        <button>회원수정 처리 요청</button>
      </a>
    </td>
    <td>
      <form action="one" method="post">
        id : <input type="text" name="id" value="100"><br>
        <button>회원정보 처리 요청</button>
      </form>
    </td>
  </tr></table></body></html>
