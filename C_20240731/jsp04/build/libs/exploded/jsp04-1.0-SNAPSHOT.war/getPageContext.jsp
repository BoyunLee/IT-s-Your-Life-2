<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Get Page Context</title>
</head>
<body>
<h2>Get Page Context</h2>

<%
    // pageContext 객체를 사용하여 설정값 불러오기
    String pageSetting = (String) pageContext.getAttribute("pageSetting", PageContext.PAGE_SCOPE);

    if (pageSetting != null) {
        out.println("<p>Saved Setting: " + pageSetting + "</p>");
    } else {
        out.println("<p>No setting found. Please set a value first.</p>");
    }
%>

<p><a href="setPageContext.jsp">Set a new value</a></p>
</body>
</html>
