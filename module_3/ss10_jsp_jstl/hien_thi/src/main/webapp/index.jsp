<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<a href="/CustomerServlet">show Customer</a>

<c:forEach var="customer" items="${list}" varStatus="loop">
    <table border="1" style="border-collapse: collapse">

    <tr>
        <td>${loop.count}</td>
        <td><c:out value="${customer.name}"/></td>
        <td><c:out value="${customer.date}"/></td>
        <td><c:out value="${customer.dress}"/></td>
        <td><c:out value="${customer.image}"/></td>
    </tr>
    </table>
</c:forEach>

</body>
</html>