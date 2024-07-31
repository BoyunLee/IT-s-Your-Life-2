<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Set Page Context</title>
</head>
<body>
<h2>Set Page Context</h2>
<form action="setPageContext.jsp" method="post">
    Setting: <input type="text" name="settingValue" />
    <input type="submit" value="Save Setting" />
</form>

<%
    if (request.getMethod().equalsIgnoreCase("POST")) {
        // request 객체를 통해 사용자 입력 데이터 가져오기
        String settingValue = request.getParameter("settingValue");

        // pageContext 객체를 사용하여 설정값 저장
        pageContext.setAttribute("pageSetting", settingValue, PageContext.PAGE_SCOPE);

        out.println("<p>Setting saved: " + settingValue + "</p>");
    }
%>
</body>
</html>
