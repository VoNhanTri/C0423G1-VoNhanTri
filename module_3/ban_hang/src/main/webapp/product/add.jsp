<%--
  Created by IntelliJ IDEA.
  User: NhanTri
  Date: 8/1/2023
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<form method="post" action="/ProductServlet?action=add">
    <input name="code" >
    <input name="name" >
    <input name="price" >
    <input name="inventory" >
    <input name="description" >
    <select name="productType" >
        <c:forEach items="${typeLi
        st}" var="typeList">
            <option value="${typeList.idType}">${typeList.nameType}</option>
        </c:forEach>
    </select>
    <input name="urlImage">
    <button type="submit">ADD</button>
</form>



</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="/assets/vendors/jquery.min.js"></script>
<script src="/assets/owlcarousel/owl.carousel.js"></script>
<script>
    $(document).ready(function () {
        $('.owl-carousel').owlCarousel({
            loop: true,
            margin: 10,
            nav: false,
            dots: false,
            responsiveClass: true,
            responsive: {
                0: {
                    items: 4,
                },
                600: {
                    items: 6,
                },
                1000: {
                    items: 8,
                    loop: false,
                    margin: 20
                }
            }
        })
    })
</script>
</html>
