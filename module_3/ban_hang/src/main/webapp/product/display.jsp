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
    <title>Quản Lý Sản Phẩm</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="https://cdn.datatables.net/1.13.5/css/dataTables.bootstrap5.min.css">
    <link rel="stylesheet" href="css.css">
    <link rel="stylesheet" href="/assets/owlcarousel/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="/assets/owlcarousel/assets/owl.theme.default.min.css">
</head>
<body>
<a href="/ProductServlet?action=add">Thêm Mới</a>
<table id="example" class="table table-hover">
    <tr>
        <th>id</th>
        <th>code</th>
        <th>name</th>
        <th>price</th>
        <th>inventory</th>
        <th>description</th>
        <th>product type</th>
        <th>image</th>
        <th>delete</th>
    </tr>
    <c:forEach  items="${productListDto}" var="pro" >
        <tr>
            <td>${pro.id}</td>
            <td>${pro.code}</td>
            <td>${pro.name}</td>
            <td>${pro.price}</td>
            <td>${pro.inventory}</td>
            <td>${pro.description}</td>
            <td>${pro.nameType}</td>
            <td>${pro.urlImage}</td>
            <td>
                <button type="button" class="btn btn-danger" onclick="showModal(${pro.id})">
                    Delete
                </button>
            </td>
        </tr>

    </c:forEach>
</table>
<%--modal--%>
<form action="/ProductServlet?action=delete" method="post">
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel" >Delete Product</h5>
                    <button type="button" class="btn-close" data-bs-dismis="modal" aria-label="Close"></button>
                </div>
                <input type="hidden" name="id" id="id">
                <div class="modal-body">
                    Bạn có Chắc Muốn Xoá Học Sinh Có ID là <span id="idPro"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>

        </div>
    </div>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
        crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js" ;></script>
<script src="https://cdn.datatables.net/1.13.5/js/dataTables.bootstrap5.min.js"></script>
<script>
    new DataTable('#example');
    function showModal(id){
        document.getElementById("idPro").innerText = id;
        document.getElementById("id").value = id;
        $("#deleteModal").modal("show");
    }
</script>
</html>
