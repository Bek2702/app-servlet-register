<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    <%--          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">--%>
</head>
<body>

<div class="container">
    <div class="row justify-content-start">
        <h1 style="color: <%=request.getAttribute("errorMessage")!=null?"red":"white"%>"><%=request.getAttribute("errorMessage") == null ? "" : request.getAttribute("errorMessage")%>
        </h1>
        <div class="col-6">
            <form action="/register" method="post">
                <label for="nameketmon">Enter fullname</label>
                <input type="text" name="name" id="nameketmon">
                <br>

                <label for="usernameketmon">Enter username</label>
                <input type="text" name="username" id="usernameketmon">
                <br>

                <label for="password">Enter password</label>
                <input type="password" name="password" id="password">
                <br>

                <label for="prePassword">Enter pre password</label>
                <input type="password" name="prePassword" id="prePassword">
                <br>

                <button type="submit" class="btn btn-success">Register</button>

            </form>
        </div>
    </div>
</div>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"--%>
<%--        crossorigin="anonymous"></script>--%>
</body>
</html>