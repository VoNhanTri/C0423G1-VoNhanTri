<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/greeting/index" method="post">
    <input name="nhap" placeholder="nhap so tien" id="nhap">
    <select name="selectOne">
        <option value="vnd">VND</option>
        <option value="usd">USD</option>
    </select>
    <select name="selectTwo">
        <option value="usd">USD</option>
        <option value="vnd">VND</option>
    </select>
    <button type="submit">QUY DOi</button>
</form>
<p> ${bang}</p>
</body>
</html>