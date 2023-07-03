<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 7/3/2023
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>DELETE</title>
</head>
<body>
<a href="/ProductServlet">Tro Ve Danh Sach</a>
<c:if test="${mess!=null}">
    <c:out value="${mess}"/>
</c:if>
<form  method="post">
    <h3>Ban co chac xoa khong</h3>
    <fieldset>
        <legend>Thong tin san pham muon xoa</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["product"].getName()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td>Status: </td>
                <td>${requestScope["product"].getStatus()}</td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td>${requestScope["product"].getProducer()}</td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="delete customer">
                </td>
                <td>
                    <a href="/ProductServlet"></a>
                </td>
            </tr>
        </table>
    </fieldset>

</form>
</body>
</html>
