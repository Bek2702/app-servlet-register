<%@ page import="uz.pdp.model.User" %><%--
  Created by IntelliJ IDEA.
  User: siroj
  Date: 8/19/2023
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome to cabinet page <%=((User) request.getAttribute("user")).getName()%>
</h1>

<button><a href="/logout">Logout</a></button>

</body>
</html>
