<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ban Hang </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <link rel="stylesheet" href="css.css">
    <link rel="stylesheet" href="/assets/owlcarousel/assets/owl.carousel.min.css">
    <link rel="stylesheet" href="/assets/owlcarousel/assets/owl.theme.default.min.css">
</head>
<body>
<section class="header my-3">
    <div class="container ">
        <div class="row py-1 ">
            <div class="col-md-3 ">
                <img src="/logo.png" class="img-fluid" alt="Logo" width="100px">
            </div>
            <div class="col-md-4 py-4">
                <div class="input-group mb-4">
                    <input type="text" class="form-control" placeholder="Tim kiem" aria-label="Tim kiem"
                           aria-describedby="basic-addon2">
                    <span class="input-group-text" id="basic-addon2"><i class="fa-solid fa-magnifying-glass"></i></span>
                </div>
            </div>
            <div class="col-md-3 ">
                <div class="row">
                    <div class="col">
                        <div class="row">
                            <div class="col-3">
                                <div class="fs-3 text-danger"><i class="fa-solid fa-phone"></i></div>
                            </div>
                            <div class="col-9">Tu Van Ho Tro<br/><strong class="text-danger">091233445</strong></div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="row">
                            <div class="col-3">
                                <div class="fs-3 text-danger"><i class="fa-solid fa-user"></i></div>
                            </div>
                            <div class="col-9">
                                <ul class="navbar-nav m-auto">
                                    <c:if test="${sessionScope.acc != null}">
                                        <li class="nav-item">
                                            <a class="nav-link" href="#">Hello ${sessionScope.acc.username}
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="/UserServlet?action=logOut">Đăng Xuất</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${sessionScope.acc ==null}">
                                        <li class="nav-item">
                                            <a class="nav-link" href="/UserServlet?action=showAccount">
                                                Dang Nhap
                                            </a>
                                        </li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-2 ">
                <div class="row">
                    <div class="col-md-4">
                        <a href="#" class="position-relative">
                            <span class="fs-3"><i class="fa-regular fa-heart"></i></span>
                            <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">0</span>
                        </a>
                    </div>
                    <div class="col-md-4">
                        <a href="#" class="position-relative">
                            <span class="fs-3"><i class="fa-solid fa-cart-shopping"></i></span>
                            <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">0</span>
                        </a>
                    </div>
                    <div class="col-md-4">
                        <a href="#" class="position-relative">
                            <span class="fs-3"><i class="fa-solid fa-print"></i></span>
                            <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">0</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%--end header--%>
<section class="menu my-3">
    <div class="container">
        <div class="row" style="align-items: center">
            <div class="col-md-3 ">
                <div class="dropdown">
                    <button class="btn btn dropdown fs-4" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <span><i class="fa-solid fa-bars "></i></span> Danh Muc San Pham
                    </button>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Day chuyen</a></li>
                        <li><a class="dropdown-item" href="#">nhan</a></li>
                        <li><a class="dropdown-item" href="#">lach tay</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md-9">
                <nav class="navbar navbar-expand-lg ">
                    <div class="container-fluid">
                        <div class="collapse navbar-collapse" id="navbarNav">
                            <ul class="navbar-nav d-flex justify-content-between" style="width: 100%">
                                <li class="nav-item">
                                    <a class="nav-link active text-dark fs-5" aria-current="page" href="/index.jsp">Trang
                                        Chu</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link text-dark fs-5 " href="#">Gioi Thieu</a>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle text-da fs-5" href="#" role="button"
                                       data-bs-toggle="dropdown" aria-expanded="false">
                                        San Pham
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="#">Action</a></li>
                                        <li><a class="dropdown-item" href="#">Another action</a></li>
                                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                                    </ul>
                                </li>
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" role="button"
                                           data-bs-toggle="dropdown" aria-expanded="false">
                                            Quan Ly
                                        </a>
                                        <ul class="dropdown-menu dropdown-menu-dark">
                                            <li><a class="dropdown-item" href="#">Action</a></li>
                                            <li><a class="dropdown-item" href="#">Another action</a></li>
                                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                                        </ul>
                                    </li>

                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</section>
<%--end menu--%>
<section class="content my-3">
    <div class="container">
        <div class="slide mb-3">
            <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active" data-bs-interval="2000">
                        <img src="/Gearvn_vũ%20trụ%20mới_%20(18).jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item" data-bs-interval="2000">
                        <img src="/Gearvn_vũ%20trụ%20mới_%20(18).jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item" data-bs-interval="2000">
                        <img src="/Gearvn_vũ%20trụ%20mới_%20(19).jpg" class="d-block w-100" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval"
                        data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval"
                        data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
        <%--end slider--%>
        <div class="cate-list mb-3 ">
            <div class="row">
                <div class="large-12 columns">
                    <div class="owl-carousel owl-theme">
                        <div class="item">
                            <div class="category-con">
                                <img src="chunky.png" class="img-fluid">
                                <h5>Ten Chu De</h5>
                            </div>
                        </div>
                        <div class="item">
                            <div class="category-con">
                                <img src="chunky.png" class="img-fluid">
                                <h5>Ten Chu De</h5>
                            </div>
                        </div>
                        <div class="item">
                            <div class="category-con">
                                <img src="chunky.png" class="img-fluid">
                                <h5>Ten Chu De</h5>
                            </div>
                        </div>
                        <div class="item">
                            <div class="category-con">
                                <img src="chunky.png" class="img-fluid">
                                <h5>Ten Chu De</h5>
                            </div>
                        </div>
                        <div class="item">
                            <div class="category-con">
                                <img src="chunky.png" class="img-fluid">
                                <h5>Ten Chu De</h5>
                            </div>
                        </div>
                        <div class="item">
                            <div class="category-con">
                                <img src="chunky.png" class="img-fluid">
                                <h5>Ten Chu De</h5>
                            </div>
                        </div>
                        <div class="item">
                            <div class="category-con">
                                <img src="chunky.png" class="img-fluid">
                                <h5>Ten Chu De</h5>
                            </div>
                        </div>
                        <div class="item">
                            <div class="category-con">
                                <img src="chunky.png" class="img-fluid">
                                <h5>Ten Chu De</h5>
                            </div>
                        </div>
                        <div class="item">
                            <div class="category-con">
                                <img src="chunky.png" class="img-fluid">
                                <h5>Ten Chu De</h5>
                            </div>
                        </div>
                        <div class="item">
                            <div class="category-con">
                                <img src="chunky.png" class="img-fluid">
                                <h5>Ten Chu De</h5>
                            </div>
                        </div>
                        <div class="item">
                            <div class="category-con">
                                <img src="chunky.png" class="img-fluid">
                                <h5>Ten Chu De</h5>
                            </div>
                        </div>
                        <div class="item">
                            <div class="category-con">
                                <img src="chunky.png" class="img-fluid">
                                <h5>Ten Chu De</h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%--  end cate-list --%>
        <div class="product mb-3">
            <div class="product-title border-bottom">
                <div class="row">
                    <div class="col-md-4">
                        <strong class="bg-danger text-white ">Mon An</strong>
                    </div>
                    <div class="col-md-8 ">
                        <div class="row">
                            <div class="col-md-4 ">
                                <a href="#" class="btn btn-C7E9B0 active" role="button" data-bs-toggle="button"
                                   aria-pressed="true">Cha CHien</a>
                            </div>
                            <div class="col-md-4 ">
                                <a href="#" class="btn btn-C7E9B0 active" role="button" data-bs-toggle="button"
                                   aria-pressed="true">Cha Hap</a>
                            </div>
                            <div class="col-md-4 ">
                                <a href="#" class="btn btn-C7E9B0 active" role="button" data-bs-toggle="button"
                                   aria-pressed="true">Cha Song</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%--    end product--%>
        <div class="product-list ">
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="card" style="width: 18rem;">
                        <img src="chunky.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of the card's content.</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">An item</li>
                            <li class="list-group-item">A second item</li>
                            <li class="list-group-item">A third item</li>
                        </ul>
                        <div class="card-body">
                            <a href="#" class="card-link">Card link</a>
                            <a href="#" class="card-link">Another link</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="card" style="width: 18rem;">
                        <img src="chunky.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of the card's content.</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">An item</li>
                            <li class="list-group-item">A second item</li>
                            <li class="list-group-item">A third item</li>
                        </ul>
                        <div class="card-body">
                            <a href="#" class="card-link">Card link</a>
                            <a href="#" class="card-link">Another link</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="card" style="width: 18rem;">
                        <img src="chunky.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of the card's content.</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">An item</li>
                            <li class="list-group-item">A second item</li>
                            <li class="list-group-item">A third item</li>
                        </ul>
                        <div class="card-body">
                            <a href="#" class="card-link">Card link</a>
                            <a href="#" class="card-link">Another link</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="card" style="width: 18rem;">
                        <img src="chunky.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of the card's content.</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">An item</li>
                            <li class="list-group-item">A second item</li>
                            <li class="list-group-item">A third item</li>
                        </ul>
                        <div class="card-body">
                            <a href="#" class="card-link">Card link</a>
                            <a href="#" class="card-link">Another link</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="card" style="width: 18rem;">
                        <img src="chunky.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of the card's content.</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">An item</li>
                            <li class="list-group-item">A second item</li>
                            <li class="list-group-item">A third item</li>
                        </ul>
                        <div class="card-body">
                            <a href="#" class="card-link">Card link</a>
                            <a href="#" class="card-link">Another link</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="card" style="width: 18rem;">
                        <img src="chunky.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of the card's content.</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">An item</li>
                            <li class="list-group-item">A second item</li>
                            <li class="list-group-item">A third item</li>
                        </ul>
                        <div class="card-body">
                            <a href="#" class="card-link">Card link</a>
                            <a href="#" class="card-link">Another link</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="card" style="width: 18rem;">
                        <img src="chunky.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of the card's content.</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">An item</li>
                            <li class="list-group-item">A second item</li>
                            <li class="list-group-item">A third item</li>
                        </ul>
                        <div class="card-body">
                            <a href="#" class="card-link">Card link</a>
                            <a href="#" class="card-link">Another link</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="card" style="width: 18rem;">
                        <img src="chunky.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of the card's content.</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">An item</li>
                            <li class="list-group-item">A second item</li>
                            <li class="list-group-item">A third item</li>
                        </ul>
                        <div class="card-body">
                            <a href="#" class="card-link">Card link</a>
                            <a href="#" class="card-link">Another link</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>
<section class="footer my-3 py-4">
    <div class="container">
        <div class="row" align="center">
            <div class="col-md-4">
                <h5>Van Phong</h5>
                <ul class="list-menu">
                    <li class="li_menu"><a href="#">Trang Chu</a></li>
                    <li class="li_menu"><a href="#">Gioi Thieu</a></li>
                    <li class="li_menu"><a href="#">San Pham</a></li>
                    <li class="li_menu"><a href="#">Lien He</a></li>
                </ul>
            </div>
            <div class="col-md-4">
                <h5>Ve Chung Toi</h5>
                <ul class="list-menu">
                    <li class="li_menu"><a href="#">Trang Chu</a></li>
                    <li class="li_menu"><a href="#">Gioi Thieu</a></li>
                    <li class="li_menu"><a href="#">San Pham</a></li>
                    <li class="li_menu"><a href="#">Lien He</a></li>
                </ul>
            </div>
            <div class="col-md-4">
                <h5>Chinh Sach Ban Hang</h5>
                <ul class="list-menu">
                    <li class="li_menu"><a href="#">Trang Chu</a></li>
                    <li class="li_menu"><a href="#">Gioi Thieu</a></li>
                    <li class="li_menu"><a href="#">San Pham</a></li>
                    <li class="li_menu"><a href="#">Lien He</a></li>
                </ul>
            </div>
        </div>
        <hr>
        <div class="row " align="center">
            <div class="col-md-6">
                <h5>Thien Duong Hai San DO AN NGONN</h5>
                <p style="color: white">Nghia An - Quang Ngai</p>
            </div>
            <div class="col-md-6">
                <h5>Lien Ket</h5>
                <span class="fs-3"><a href="#"><i class="fa-brands fa-facebook"></i></a></span>
                <span class="fs-3"><a href="#"><i class="fa-brands fa-tiktok"></i></a></span>
            </div>
        </div>
        <hr>
        <div class="row text-center">
            <h6>Ban Quyen @81723698123</h6>
        </div>

    </div>
</section>

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