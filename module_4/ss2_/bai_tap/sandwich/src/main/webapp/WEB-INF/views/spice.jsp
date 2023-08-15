<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 8/15/2023
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Sandwich Condiments</h3>
<form action="/home/save" method="post">
<input type="checkbox" name="checkbox" value="lettuce" > Lettuce
<input type="checkbox" name="checkbox" value="tomato"> Tomato
<input type="checkbox" name="checkbox" value="mustard"> Mustard
<input type="checkbox" name="checkbox" value="sprouts"> Sprouts
    <button type="submit">Save</button>
</form>
<p>${checkbox}</p>
</body>
</html>
