<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Calculator</h1>>
<form method="get" action="/caculator.jsp" >
    <fieldset>
    <label>First Operand</label>
    <input type="number" name="firstNum">
    <br/>
    <label>Operator</label>
    <select name="choose">
        <option value="total">+</option>
        <option value="sub">-</option>
        <option value="core">*</option>
        <option value="div">+</option>
    </select>
        <br/>
    <label>Second Operand</label>
    <input type="number" name="secondNum">
    <br/>
    <button name="submit">Calculator</button>
    </fieldset>
</form>
</body>
</html>