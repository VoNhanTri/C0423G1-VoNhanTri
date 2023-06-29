<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Discount Calculator</title>
</head>
<body>
<h1><%= "Calculator" %>
</h1>
<form method="post" action="/DescriptionServlet">
    <label>Description</label><br/>
    <input type="text" name="Description" placeholder="DESCRIPTION"/><br/>
    <label>List_Price</label><br/>
    <input type="number" name="List_Price" placeholder="LIST_PRICE"/><br/>
    <label>Discount_Percent</label><br/>
    <input type="number" name="Discount_Percent" placeholder="DISCOUNT_PERCENT">
    <button type="submit" name="button">Submit</button>
</form>
<br/>
</body>
</html>