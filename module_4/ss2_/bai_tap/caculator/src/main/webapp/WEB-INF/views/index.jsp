<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 8/15/2023
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Calculator</h2>
<form action="/home/index" method="post">
  <input name="numberOne" placeholder="Number Enter">
  <input name="numberTwo" placeholder="Number Enter">
  <button name="calculator" value="addition">Addition(+)</button>
  <button name="calculator" value="subtraction">Subtraction(-)</button>
  <button name="calculator" value="multiplication">Multiplication(x)</button>
  <button name="calculator" value="division">Division(/)</button>
</form>
<p>${result}</p>
</body>
</html>
