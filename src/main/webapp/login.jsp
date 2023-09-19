<%--
  Created by IntelliJ IDEA.
  User: siroj
  Date: 8/19/2023
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <h1>Login Form:</h1>
    <h4 style="color:<%=request.getAttribute("errorMessage") == null ? "white" : "red "%> " ><%=request.getAttribute("errorMessage") == null ? " " : request.getAttribute("errorMessage")%>
    </h4>
    <div class="card">
        <div class="card-body">
            <form action="/login" method="post">

                <div class="form-group row">
                    <label for="username" class="col-sm-2 col-form-label">Username</label>
                    <div class="col-sm-7">
                        <input id="username" type="text" class="form-control" name="username"
                               placeholder="Enter username">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="password" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-7">
                        <input id="password" type="password" class="form-control" name="password"
                               placeholder="Enter password">
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>


</body>
</html>
