<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html><head> <title>게시판</title></head><body>
<h1>welcome spring world!</h1><br/>
<table border="1">
  <tr style="width: 400px;">
    <td style="background: pink">게시판 글 작성</td>
    <td style="background: pink">게시판 글 삭제</td>
    <td style="background: pink">게시판 글 수정</td>
    <td style="background: pink">게시판 글 검색</td>
  </tr>
  <tr>
    <td>
      <form action="insert">
        no : <input name="no" value="1"><br>
        title : <input name="title" value="fun"><br>
        content : <input name="content" value="fun"><br>
        writer : <input name="writer" value="apple"><br>
        <button>게시판 글 작성 처리 요청</button>
      </form>
    </td>
    <td>
      <a href="delete?no=1">
        <button>게시판 글 삭제 처리 요청</button>
      </a>
    </td>
    <td>
      <form action="update">
        no : <input name="no" value="1"><br>
        title : <input name="title" value="fun"><br>
        <button>게시판 글 수정 처리 요청</button>
      </form>
     </td>
    <td>
      <form action="one" method="post">
        no : <input name="no" value="1"><br>
        <button>게시판 글 검색 처리 요청</button>
      </form>
    </td>
  </tr></table></body></html>
