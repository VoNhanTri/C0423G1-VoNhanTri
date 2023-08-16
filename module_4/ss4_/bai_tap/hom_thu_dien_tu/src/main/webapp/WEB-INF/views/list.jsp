<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 8/16/2023
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/home/mail">Them moi</a>
<p style="">${mess}</p>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Language</th>
        <th>sizePage</th>
        <th>spams</th>
        <th>signature</th>
        <th>detail</th>
    </tr>
    <c:forEach var="mailBox" items="${mailBoxList}">
        <tr>
            <td>${mailBox.id}</td>
            <td>${mailBox.languages}</td>
            <td>${mailBox.sizePage}</td>
            <td>${mailBox.spams}</td>
            <td>${mailBox.signature}</td>
           <td> <a href="/home/detail?id=${mailBox.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
