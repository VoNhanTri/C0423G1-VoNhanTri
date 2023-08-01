<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 7/31/2023
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <link rel="stylesheet" href="css.css">
    <link rel="stylesheet" href="/assets/owlcarousel/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="/assets/owlcarousel/assets/owl.theme.default.min.css">
</head>
<body>
<a href="/ProductServlet?action=showAdd">them moi</a>
<table id="example" class="table table-hover">
    <tr>
        <th>code</th>
        <th>name</th>
        <th>image</th>
        <th>price</th>
        <th>inventory</th>
        <th>description</th>
        <th>name product type</th>
    </tr>
    <c:forEach var="pro" items="${productList}">
        <tr>
            <td><c:out value="${pro.code}"/></td>
            <td><c:out value="${pro.name}"/></td>
            <td><c:out value="${pro.image}"/></td>
            <td><c:out value="${pro.price}"/></td>
            <td><c:out value="${pro.inventory}"/></td>
            <td><c:out value="${pro.description}"/></td>
            <td><c:out value="${pro.productType}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>


</html>
