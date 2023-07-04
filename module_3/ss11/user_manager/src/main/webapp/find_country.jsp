<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 7/4/2023
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/UsersServlet?action=findCountry">Tiem kiem bang country</a>
<c:if test="${mess!=null}">
  <c:out value="${mess}"/>
</c:if>
<table>
  <tr>
    <td><c:out value="${users.id}"/></td>
    <td><c:out value="${users.name}"/></td>
    <td><c:out value="${users.email}"/></td>
    <td><c:out value="${users.country}"/></td>
  </tr>
</table>
</body>
</html>
