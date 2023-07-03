<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 7/3/2023
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/ProductServlet">Tro Ve Danh Sach</a>
<c:if test="${mess !=null}">
    <c:out value="${mess}"/>
</c:if>
<form action="/ProductServlet?action=create" method="post">
    <label for="id">ID: </label>
    <input type="number" name="id" id="id">
    <label for="name">Name: </label>
    <input type="text" name="name" id="name">
    <label for="price">Price</label>
    <input type="number" name="price" id="price">
    <label for="status">Status</label>
    <input type="text" name="status" id="status">
    <label for="producer">Producer</label>
    <input type="text" name="producer" id="producer">
   <input type="submit" value="submit">
</form>
</body>
</html>
