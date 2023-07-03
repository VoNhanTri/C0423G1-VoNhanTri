<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 7/3/2023
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/ProductServlet?action=create">Them Moi</a>
<c:if test="${mess != null}">
    <c:out value="${mess}"/>
</c:if>
<table>
    <tr>
        <td>ID</td>
        <td>Ten San Pham</td>
        <td>Gia</td>
        <td>Mo Ta San Pham</td>
        <td>Nha San Xuat</td>
        <td>xoa</td>
    </tr>
    <c:forEach var="product" items="${productList}" >
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><c:out value="${product.status}"/></td>
            <td><c:out value="${product.producer}"/></td>
            <td><a href="/ProductServlet?action=delete&id=${product.getId()}">Xoa</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
