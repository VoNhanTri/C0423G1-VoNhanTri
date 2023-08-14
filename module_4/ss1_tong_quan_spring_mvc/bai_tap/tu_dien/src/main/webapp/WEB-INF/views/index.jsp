<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 8/14/2023
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Tu Dien</h1>
<form action="/tudien/index" method="post">
    <input name="nhap" id="nhap" placeholder="nhap tu muon dich">
    <button type="submit" name="submit">Dich</button>
</form>
<p>${dich}</p>
</body>
</html>
