<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 7/4/2023
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/ProductServlet?action=find">Tim kiếm</a>
<c:if test="${mess!=null}">
    <c:out value="${mess}"/>-
</c:if>
<table>
    <tr>
        <td><c:out value="${product.id}"/></td>
        <td><c:out value="${product.name}"/></td>
        <td><c:out value="${product.price}"/></td>
        <td><c:out value="${product.status}"/></td>
        <td><c:out value="${product.producer}"/></td>
    </tr>
</table>
</body>
</html>
