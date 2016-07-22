<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>管理系统</title>
    <link rel="stylesheet" href="./dist/css/bootstrap.css">
    <link rel="stylesheet" href="./src/css/signin.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
    <%
        session.setAttribute("login", "false");
        session.setAttribute("user","游客");
    %>
    <%@include file="header.jsp"%>
    <%@include file="loginFrame.jsp"%>
</body>
</html>