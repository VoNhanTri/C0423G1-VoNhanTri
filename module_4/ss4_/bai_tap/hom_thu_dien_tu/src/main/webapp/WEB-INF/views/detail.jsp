<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 8/16/2023
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Language</th>
        <th>sizePage</th>
        <th>spams</th>
        <th>signature</th>
    </tr>
    <tr>
        <form:form method="post" action="/home/detail" modelAttribute="mailBox">
            <td><form:input path="id"/></td>
            <td><form:select path="languages">
                <form:option value="English">English</form:option>
                <form:option value="Vietnamese">Vietnamese</form:option>
                <form:option value="Japanese">Japanese</form:option>
                <form:option value="Chinese">Chinese</form:option>
            </form:select>
            </td>
            <td><form:select path="sizePage">
                <form:option value="5">5</form:option>
                <form:option value="10">10</form:option>
                <form:option value="15">15</form:option>
                <form:option value="25">25</form:option>
                <form:option value="50">50</form:option>
            </form:select>
            </td>
            <td><form:checkbox value="Enable spams filter" path="spams"/></td>
            <td><form:textarea path="signature"/></td>
            <td><form:button>Edit</form:button></td>
        </form:form>
    </tr>
</table>
</body>
</html>
