
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Electro - HTML Ecommerce Template</title>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

    <!-- Bootstrap -->

    <link type="text/css" rel="stylesheet" href="body/css/bootstrap.min.css"/>
    <!-- Slick -->
    <link type="text/css" rel="stylesheet" href="body/css/slick.css"/>
    <link type="text/css" rel="stylesheet" href="body/css/slick-theme.css"/>
    <!-- nouislider -->
    <link type="text/css" rel="stylesheet" href="body/css/nouislider.min.css"/>

    <!-- Font Awesome Icon -->
    <link rel="stylesheet" href="body/css/font-awesome.min.css">

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="body/css/style.css"/>

    <link rel="stylesheet" href="sweetalert2.min.css">

    <![endif]-->
</head>
<body>
<!-- HEADER -->
<header>
    <!-- TOP HEADER -->
    <div id="top-header">
        <div class="container">
            <ul class="header-links pull-left">
                <li><a href="#"><i class="fa fa-phone"></i> + 09857573234</a></li>
                <li><a href="#"><i class="fa fa-envelope-o"></i> long113@email.com</a></li>
                <li><a href="#"><i class="fa fa-map-marker"></i> 1734 Nguyễn Tất Thành</a></li>
            </ul>
            <ul class="header-links pull-right">
                <c:if test="${sessionScope.account.isSell == 1}">
                    <li><a href="managers"><i class="fa fa-user-o"></i> Quản lý sản phẩm</a></li>
                </c:if>
                <c:if test="${sessionScope.account.isAdmin == 1}">
                    <li><a href="dash/dashboar.jsp"><i class="fa fa-user-o"></i> Admin quản trị </a></li>

                    <li><a href="electronics?action=listProduct"><i class="fa fa-user-o"></i> Quản lý sản phẩm</a></li>
                </c:if>
                <li><a href="logout"><i class="fa fa-user-o"></i> logout</a></li>
                <c:if test="${sessionScope.account == null}">
                    <li><a href="account/login.jsp"><i class="fa fa-user-o"></i>Đăng nhập</a></li>
                </c:if>
                <c:if test="${sessionScope.account != null}">
                    <li><a href="account/login.jsp"><i class="fa fa-user-o"></i>Helloo ${sessionScope.account.userName}
                    </a></li>
                </c:if>
            </ul>
        </div>
    </div>
    <!-- /TOP HEADER -->

    <!-- MAIN HEADER -->
    <div id="header">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!-- LOGO -->
                <div class="col-md-3">
                    <div class="header-logo">
                        <a href="/electronics" class="logo">
                            <img src="img/logo.png" alt="ảnh đâu rùi nhỉ">
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-6">
                    <div class="header-search">
                        <form action="search" method="post">
                            <select class="input-select">
                                <option value="0">
                                    All Categories
                                </option>
                                <c:forEach items="${categoryList}" var="category">
                                    <option>
                                        <li><a href="category?id=${category.id}">${category.name}</a></li>
                                    </option>
                                </c:forEach>
                            </select>
                            <input value="${txtS}" class="input" name="searchList" placeholder="Search here">
                            <button class="search-btn">Search</button>
                        </form>
                    </div>
                </div>
                <!-- /SEARCH BAR -->

                <!-- ACCOUNT -->
                <div class="col-md-3 clearfix">
                    <div class="header-ctn">
                        <!-- Wishlist -->
                        <div>
                            <a href="#">
                                <i class="fa fa-heart-o"></i>
                                <span>Danh sách mong muốn của bạn</span>
                                <div class="qty">2</div>
                            </a>
                        </div>
                        <!-- /Wishlist -->

                        <!-- Cart -->
                        <div class="dropdown">
                            <div class="cart-dropdown">
                                <div class="cart-list">
                                    <c:set var="count" value="${count = 0}"></c:set>
                                    <c:set var="total" value="${total = 0}"></c:set>
                                    <c:forEach items="${order.items}" var="item">
                                        <div class="product-widget">
                                            <c:set var="count" value="${count = count + 1}"></c:set>
                                            <c:set var="total" value="${total = total + (item.electronic.price)*(item.quantity)}"></c:set>
                                            <div class="product-widget">
                                                <div class="product-img">
                                                    <img src="${item.electronic.image}" alt="">
                                                </div>
                                                <div class="product-body">
                                                    <h3 class="product-name"><a href="#">${item.electronic.name}</a></h3>
                                                    <h4 class="product-price"><span class="qty">${item.quantity}</span>
                                                        <fmt:setLocale value="vi_VN"/>
                                                        <fmt:formatNumber value="${item.electronic.price}" type="currency"/>
                                                    </h4>
                                                </div>
                                                <button class="delete">
                                                    <i class="fa fa-close">
                                                    </i></button>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                                <div class="cart-summary">
                                    <small><strong>${count}</strong> mục được chọn</small>
                                    <h5>Tổng thanh toán:
                                        <fmt:setLocale value="vi_VN"/>
                                        <fmt:formatNumber value="${total}" type="currency"/>
                                    </h5>
                                </div>

                                <div class="cart-btns">
                                    <a href="body/cart.jsp">Xem giỏ hàng</a>
                                    <a href="body/bill.jsp">Thanh toán<i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>

                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                <i class="fa fa-shopping-cart"></i>
                                <span>Giỏ hàng của bạn</span>
                                <div class="qty">${count}</div>
                            </a>
                        </div>
                        <!-- /Cart -->

                        <!-- Menu Toogle -->
                        <div class="menu-toggle">
                            <a href="#">
                                <i class="fa fa-bars"></i>
                                <span>Menu</span>
                            </a>
                        </div>
                        <!-- /Menu Toogle -->
                    </div>
                </div>
                <!-- /ACCOUNT -->
            </div>
            <!-- row -->
        </div>
        <!-- container -->
    </div>
    <!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->

<!-- NAVIGATION -->
<nav id="navigation">
    <!-- container -->
    <div class="container">
        <!-- responsive-nav -->
        <div id="responsive-nav">
            <!-- NAV -->
            <ul class="main-nav nav navbar-nav">
                <li class="active"><a href="electronics">Trang Chủ</a></li>
                <li><a href="#">Ưu đãi lớn</a></li>
                <li><a href="electronics">Tất cả</a></li>
                <c:forEach items="${categoryList}" var="category">
                    <li class="section-tab-nav tab-nav ${tag == category.id ? "active":""}"><a
                            href="category?id=${category.id}">${category.name}</a></li>
                </c:forEach>
            </ul>
            <!-- /NAV -->
        </div>
        <!-- /responsive-nav -->
    </div>
    <!-- /container -->
</nav>
<!-- /NAVIGATION -->
<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">

            <!-- section title -->
            <div class="col-md-12">
                <div class="section-title">
                    <h3 class="title">Sản phẩm mới</h3>
                    <div class="section-nav">
                        <ul class="section-tab-nav tab-nav">
                            <li><a href="electronics">Tất cả</a></li>
                            <c:forEach items="${categoryList}" var="category">
                                <li class="section-tab-nav tab-nav ${tag == category.id ? "active":""}"><a
                                        href="category?id=${category.id}">${category.name}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /section title -->

            <!-- Products tab & slick -->
            <div class="col-md-12">
                <div class="row">
                    <div class="products-tabs">
                        <!-- tab -->
                        <div id="tab1" class="tab-pane active">
                            <div class="products-slick" data-nav="#slick-nav-1">
                                <!-- com -->
                                <c:forEach items="${electronicList}" var="electronic">
                                    <div class="product">
                                        <div class="product-img">
                                            <a class="product-img" href="detail?pid=${electronic.id}">
                                                <img style="height:250px ; width:100%" src="${electronic.image}">
                                            </a>
                                            <div class="product-label">
                                                <span class="sale">-30%</span>
                                                <span class="new">MỚI</span>
                                            </div>
                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">thể loại</p>
                                            <h3 class="product-name"><a
                                                    href="detail?pid=${electronic.id}">${electronic.name}</a></h3>
                                            <h4 class="product-price" >
                                                <fmt:setLocale value="vi_VN"/>
                                                <fmt:formatNumber value=" ${electronic.price - (electronic.price* 5/100)}" type="currency"/>
                                                <del class="product-old-price">
                                                    <fmt:setLocale value="vi_VN"/>
                                                    <fmt:formatNumber value=" ${electronic.price}" type="currency"/>
                                                </del>
                                            </h4>
                                            <div class="product-rating">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                            </div>
                                            <div class="product-btns">
                                                <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span
                                                        class="tooltipp">Thêm vào danh sách mong muốn</span></button>
                                                <button class="add-to-compare"><i class="fa fa-exchange"></i><span
                                                        class="tooltipp">thêm vào để so sánh</span></button>
                                                <button class="quick-view">
                                                    <a href="detail?pid=${electronic.id}">
                                                        <i class="fa fa-eye"></i>
                                                    </a>
                                                    <span
                                                        class="tooltipp">xem lướt qua</span>
                                                </button>
                                            </div>
                                        </div>
                                        <div class="add-to-cart">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i>
                                                <a href="addToCart?pId=${electronic.id}">thêm vào giỏ hàng</a>
                                            </button>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <div id="slick-nav-1" class="products-slick-nav"></div>
                        </div>
                        <!-- /tab -->
                    </div>
                </div>
            </div>
            <!-- Products tab & slick -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <!-- shop -->
            <div class="col-md-4 col-xs-6">
                <div class="shop">
                    <div class="shop-img">
                        <img src="img/shop01.png" alt="">
                    </div>
                    <div class="shop-body">
                        <h3>Laptop<br>Collection</h3>
                        <%--                        <c:forEach items="${categoryList}" var="category">--%>
                        <%--                            <li class="section-tab-nav tab-nav ${tag == category.id ? "active":""}"><a--%>
                        <%--                                    href="category?id=${category.id}">${category.name}</a></li>--%>
                        <%--                        </c:forEach>--%>
                        <a href="#" class="cta-btn">Mua ngay bây giờ<i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
            </div>
            <!-- /shop -->

            <!-- shop -->
            <div class="col-md-4 col-xs-6">
                <div class="shop">
                    <div class="shop-img">
                        <img src="img/shop03.png" alt="">
                    </div>
                    <div class="shop-body">
                        <h3>Accessories<br>Collection</h3>
                        <a href="#" class="cta-btn">Mua ngay bây giờ<i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
            </div>
            <!-- /shop -->

            <!-- shop -->
            <div class="col-md-4 col-xs-6">
                <div class="shop">
                    <div class="shop-img">
                        <img src="img/shop02.png" alt="">
                    </div>
                    <div class="shop-body">
                        <h3>Cameras<br>Collection</h3>
                        <a href="#" class="cta-btn">Mua ngay bây giờ <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
            </div>
            <!-- /shop -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<!-- HOT DEAL SECTION -->
<div id="hot-deal" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <div class="hot-deal">
                    <ul class="hot-deal-countdown">
                        <li>
                            <div>
                                <h3>02</h3>
                                <span>Days</span>
                            </div>
                        </li>
                        <li>
                            <div>
                                <h3>10</h3>
                                <span>Hours</span>
                            </div>
                        </li>
                        <li>
                            <div>
                                <h3>34</h3>
                                <span>Mins</span>
                            </div>
                        </li>
                        <li>
                            <div>
                                <h3>60</h3>
                                <span>Secs</span>
                            </div>
                        </li>
                    </ul>
                    <h2 class="text-uppercase">Thỏa thuận nóng trong tuần này</h2>
                    <p>Bộ sưu tập mới giảm tới 50% </p>
                    <a class="primary-btn cta-btn" href="#">Shop now</a>
                </div>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /HOT DEAL SECTION -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">

            <!-- section title -->
            <div class="col-md-12">
                <div class="section-title">
                    <h3 class="title">Top selling</h3>
                    <%--                    <div class="section-nav">--%>
                    <%--                        <ul class="section-tab-nav tab-nav">--%>
                    <%--                            <c:forEach items="${categoryList}" var="category">--%>
                    <%--                                <li><a href="#">${category.name}</a></li>--%>
                    <%--                            </c:forEach>--%>
                    <%--                        </ul>--%>
                    <%--                    </div>--%>
                </div>
            </div>
            <!-- /section title -->

            <!-- Products tab & slick -->
            <div>
                <div class="col-md-12">
                    <div class="row">
                        <div class="products-tabs">
                            <!-- tab -->
                            <div id="tab2" class="tab-pane fade in active">
                                <div class="products-slick" data-nav="#slick-nav-2">
                                    <!-- com -->
                                    <c:forEach items="${electronicList}" var="electronic">
                                        <div class="product">
                                            <div class="product-img">
                                                <a class="product-img" href="detail?pid=${electronic.id}">
                                                    <img style="width: 200px; height: 200px" src="${electronic.image}">
                                                </a>
                                                <div class="product-label">
                                                    <span class="sale">-30%</span>
                                                    <span class="new">MỚI</span>
                                                </div>
                                            </div>
                                            <div class="product-body">
                                                <p class="product-category">thể loại</p>
                                                <h3 class="product-name"><a
                                                        href="detail?pid=${electronic.id}">${electronic.name}</a></h3>
                                                <h4 class="product-price">
                                                    <fmt:setLocale value="vi_VN"/>
                                                    <fmt:formatNumber value=" ${electronic.price - (electronic.price* 5/100)}" type="currency"/>
                                                    <del class="product-old-price">
                                                        <fmt:setLocale value="vi_VN"/>
                                                        <fmt:formatNumber value=" ${electronic.price}" type="currency"/>
                                                    </del>
                                                </h4>
                                                <div class="product-rating">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </div>
                                                <div class="product-btns">
                                                    <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span
                                                            class="tooltipp">Thêm vào danh sách mong muốn</span>
                                                    </button>
                                                    <button class="add-to-compare"><i class="fa fa-exchange"></i><span
                                                            class="tooltipp">thêm vào để so sánh</span></button>
                                                    <button class="quick-view"><i class="fa fa-eye"></i><span
                                                            class="tooltipp">xem lướt qua</span>
                                                    </button>
                                                </div>
                                            </div>
                                            <div class="add-to-cart">
                                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> thêm
                                                    vào
                                                    giỏ hàng
                                                </button>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div id="slick-nav-2" class="products-slick-nav"></div>
                        </div>
                        <!-- /tab -->
                    </div>
                </div>
            </div>
            <!-- /Products tab & slick -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-4 col-xs-6">
                <div class="section-title">
                    <h4 class="title">Top selling</h4>
                    <div class="section-nav">
                        <div id="slick-nav-3" class="products-slick-nav"></div>
                    </div>
                </div>

                <div class="products-widget-slick" data-nav="#slick-nav-3">
                    <div>
                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product07.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /com widget -->

                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product08.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /com widget -->

                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product09.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- com widget -->
                    </div>

                    <div>
                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product01.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /com widget -->

                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product02.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /com widget -->

                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product03.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- com widget -->
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xs-6">
                <div class="section-title">
                    <h4 class="title">Top selling</h4>
                    <div class="section-nav">
                        <div id="slick-nav-4" class="products-slick-nav"></div>
                    </div>
                </div>

                <div class="products-widget-slick" data-nav="#slick-nav-4">
                    <div>
                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product04.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /com widget -->

                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product05.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /com widget -->

                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product06.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- com widget -->
                    </div>

                    <div>
                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product07.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /com widget -->

                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product08.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /com widget -->

                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product09.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- com widget -->
                    </div>
                </div>
            </div>

            <div class="clearfix visible-sm visible-xs"></div>

            <div class="col-md-4 col-xs-6">
                <div class="section-title">
                    <h4 class="title">Top selling</h4>
                    <div class="section-nav">
                        <div id="slick-nav-5" class="products-slick-nav"></div>
                    </div>
                </div>

                <div class="products-widget-slick" data-nav="#slick-nav-5">
                    <div>
                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product01.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /com widget -->

                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product02.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /com widget -->

                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product03.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- com widget -->
                    </div>

                    <div>
                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product04.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /com widget -->

                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product05.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- /com widget -->

                        <!-- com widget -->
                        <div class="product-widget">
                            <div class="product-img">
                                <img src="img/product06.png" alt="">
                            </div>
                            <div class="product-body">
                                <p class="product-category">Category</p>
                                <h3 class="product-name"><a href="#">com name goes here</a></h3>
                                <h4 class="product-price">$980.00
                                    <del class="product-old-price">$990.00</del>
                                </h4>
                            </div>
                        </div>
                        <!-- com widget -->
                    </div>
                </div>
            </div>

        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<!-- NEWSLETTER -->
<div id="newsletter" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <div class="newsletter">
                    <p>Sign Up for the <strong>NEWSLETTER</strong></p>
                    <form>
                        <input class="input" type="email" placeholder="Enter Your Email">
                        <button class="newsletter-btn"><i class="fa fa-envelope"></i> Subscribe</button>
                    </form>
                    <ul class="newsletter-follow">
                        <li>
                            <a href="#"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /NEWSLETTER -->

<!-- FOOTER -->
<footer id="footer">
    <!-- top footer -->
    <div class="section">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">About Us</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt
                            ut.</p>
                        <ul class="footer-links">
                            <li><a href="#"><i class="fa fa-map-marker"></i>1734 Stonecoal Road</a></li>
                            <li><a href="#"><i class="fa fa-phone"></i>+021-95-51-84</a></li>
                            <li><a href="#"><i class="fa fa-envelope-o"></i>email@email.com</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Categories</h3>
                        <ul class="footer-links">
                            <li><a href="#">Hot deals</a></li>
                            <li><a href="#">Laptops</a></li>
                            <li><a href="#">Smartphones</a></li>
                            <li><a href="#">Cameras</a></li>
                            <li><a href="#">Accessories</a></li>
                        </ul>
                    </div>
                </div>

                <div class="clearfix visible-xs"></div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Information</h3>
                        <ul class="footer-links">
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Contact Us</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Orders and Returns</a></li>
                            <li><a href="#">Terms & Conditions</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Service</h3>
                        <ul class="footer-links">
                            <li><a href="#">My Account</a></li>
                            <li><a href="#">View Cart</a></li>
                            <li><a href="#">Wishlist</a></li>
                            <li><a href="#">Track My Order</a></li>
                            <li><a href="#">Help</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /top footer -->

    <!-- bottom footer -->
    <div id="bottom-footer" class="section">
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-12 text-center">
                    <ul class="footer-payments">
                        <li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
                        <li><a href="#"><i class="fa fa-credit-card"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-amex"></i></a></li>
                    </ul>
                    <span class="copyright">
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i
                            class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com"
                                                                                target="_blank">Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</span>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /bottom footer -->
</footer>
<!-- /FOOTER -->

<!-- jQuery Plugins -->
<%--// chỗ này này--%>
<script src="sweetalert2.min.js"></script>
<script src="body/js/jquery.min.js"></script>
<script src="body/js/bootstrap.min.js"></script>
<script src="body/js/slick.min.js"></script>
<script src="body/js/nouislider.min.js"></script>
<script src="body/js/jquery.zoom.min.js"></script>
<script src="body/js/main.js"></script>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</body>
</html>
