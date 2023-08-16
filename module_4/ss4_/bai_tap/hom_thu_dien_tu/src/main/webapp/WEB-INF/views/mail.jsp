<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 8/16/2023
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="/home/mail" modelAttribute="mailBox">
    ID
    <form:input path="id"/><br/>
    Languages
    <form:select path="languages">
        <form:option value="English">English</form:option>
        <form:option value="Vietnamese">Vietnamese</form:option>
        <form:option value="Japanese">Japanese</form:option>
        <form:option value="Chinese">Chinese</form:option>
    </form:select><br/>
    Page Size: show <form:select path="sizePage">
                        <form:option value="5">5</form:option>
                        <form:option value="10">10</form:option>
                        <form:option value="15">15</form:option>
                        <form:option value="25">25</form:option>
                         <form:option value="50">50</form:option>
                    </form:select> email per page<br/>
    Spams filter <form:checkbox value="Enable spams filter" path="spams"/>Enable spams filter <br/>
    Signature: <form:textarea path="signature"/>
    <form:button>Add</form:button>
    <form:button>Cancel</form:button>
</form:form>
</body>
</html>
