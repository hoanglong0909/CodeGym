<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

    <!-- Slick -->
    <link type="text/css" rel="stylesheet" href="css/slick.css"/>
    <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

    <!-- nouislider -->
    <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

    <!-- Font Awesome Icon -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="css/style.css"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
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
                    <li><a href="/managers"><i class="fa fa-user-o"></i> Quản lý sản phẩm</a></li>
                </c:if>
                <c:if test="${sessionScope.account.isAdmin == 1}">
                    <li><a href="/dash/dashboar.jsp"><i class="fa fa-user-o"></i> Admin quản trị </a></li>

                    <li><a href="electronics?action=listProduct"><i class="fa fa-user-o"></i> Quản lý sản phẩm</a></li>
                </c:if>
                <li><a href="/logout"><i class="fa fa-user-o"></i> logout</a></li>
                <c:if test="${sessionScope.account == null}">
                    <li><a href="/account/login.jsp"><i class="fa fa-user-o"></i>Đăng nhập</a></li>
                </c:if>
                <c:if test="${sessionScope.account != null}">
                    <li><a href="/account/login.jsp"><i class="fa fa-user-o"></i>Helloo ${sessionScope.account.userName}
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
                            <img src="img/logo.png" alt="">
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-6">
                    <div class="header-search">
                        <form>
                            <select class="input-select">
                                <option value="0">All Categories</option>
                                <option value="1">Category 01</option>
                                <option value="1">Category 02</option>
                            </select>
                            <input class="input" placeholder="Search here">
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
                                <span>Sản phẩm yêu thích của bạn</span>
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
                                    <a href="/body/cart.jsp">Xem giỏ hàng</a>
                                    <a href="/body/bill.jsp">Thanh toán<i class="fa fa-arrow-circle-right"></i></a>
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
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">Hot Deals</a></li>
                <li><a href="#">Categories</a></li>
                <li><a href="#">Laptops</a></li>
                <li><a href="#">Smartphones</a></li>
                <li><a href="#">Cameras</a></li>
                <li><a href="#">Accessories</a></li>
            </ul>
            <!-- /NAV -->
        </div>
        <!-- /responsive-nav -->
    </div>
    <!-- /container -->
</nav>
<!-- /NAVIGATION -->

<!-- BREADCRUMB -->
<div id="breadcrumb" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <h3 class="breadcrumb-header">Thủ tục thanh toán
                </h3>
                <ul class="breadcrumb-tree">
                    <li><a href="#">Trang Chủ</a></li>
                    <li class="active">Thủ tục thanh toán</li>
                </ul>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /BREADCRUMB -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">

            <div class="col-md-7">
                <!-- Billing Details -->

                <div class="billing-details">
                    <div class="section-title">
                        <h3 class="title">Địa chỉ thanh toán</h3>
                    </div>
                    <div class="form-group">
                        <input class="input" type="text" name="first-name" placeholder="Tên">
                    </div>
                    <div class="form-group">
                        <input class="input" type="text" name="last-name" placeholder="Họ">
                    </div>
                    <div class="form-group">
                        <input class="input" type="email" name="email" placeholder="Email">
                    </div>
                    <div class="form-group">
                        <input class="input" type="text" name="address" placeholder="Địa chỉ">
                    </div>
                    <div class="form-group">
                        <input class="input" type="text" name="city" placeholder="Thành phố.">
                    </div>
                    <div class="form-group">
                        <input class="input" type="text" name="country" placeholder="Quốc gia">
                    </div>
                    <div class="form-group">
                        <input class="input" type="text" name="zip-code" placeholder="Mã Bưu Chính">
                    </div>
                    <div class="form-group">
                        <input class="input" type="tel" name="tel" placeholder="Điện thoại">
                    </div>

                    <div class="form-group">
                        <div class="input-checkbox">
                            <input type="checkbox" id="create-account">
                            <label for="create-account" >
                                <a href="/account/login.jsp">Tạo tài khoản ?</a>
                            </label>
<%--                            <div class="caption">--%>
<%--                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor--%>
<%--                                    incididunt.</p>--%>
<%--                                <input class="input" type="password" name="password" placeholder="Enter Your Password">--%>
<%--                            </div>--%>
                        </div>
                    </div>

                </div>
                <!-- /Billing Details -->

                <!-- Shiping Details -->
                <div class="shiping-details">
                    <div class="section-title">
                        <h3 class="title">Giao hàng địa chỉ</h3>
                    </div>
                    <div class="input-checkbox">
                        <input type="checkbox" id="shiping-address">
                        <label for="shiping-address">
                            <span></span>
                            Gửi đến một địa chỉ khác nhau?
                        </label>
                        <div class="caption">
                            <div class="form-group">
                                <input class="input" type="text" name="first-name" placeholder="Tên ">
                            </div>
                            <div class="form-group">
                                <input class="input" type="text" name="last-name" placeholder="Họ.">
                            </div>
                            <div class="form-group">
                                <input class="input" type="email" name="email" placeholder="E-mail">
                            </div>
                            <div class="form-group">
                                <input class="input" type="text" name="address" placeholder="Địa chỉ">
                            </div>
                            <div class="form-group">
                                <input class="input" type="text" name="city" placeholder="Thành phố.">
                            </div>
                            <div class="form-group">
                                <input class="input" type="text" name="country" placeholder="Quốc gia
">
                            </div>
                            <div class="form-group">
                                <input class="input" type="text" name="zip-code" placeholder="Mã Bưu Chính">
                            </div>
                            <div class="form-group">
                                <input class="input" type="tel" name="tel" placeholder="Điện thoại">
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Shiping Details -->

                <!-- Order notes -->
                <div class="order-notes">
                    <textarea class="input" placeholder="Order Notes"></textarea>
                </div>
                <!-- /Order notes -->
            </div>

            <!-- Order Details -->
            <div class="col-md-5 order-details">
                <div class="section-title text-center">
                    <h3 class="title">Đơn hàng của bạn</h3>
                </div>
                <div class="order-summary">
                    <div class="order-col">
                        <div><strong>Sản phẩm</strong></div>
                        <div><strong>TOTAL</strong></div>
                    </div>
                    <c:set var="count" value="${count = 0}"></c:set>
                    <c:set var="total" value="${total = 0}"></c:set>
                    <c:forEach items="${order.items}" var="item">
                        <c:set var="count" value="${count = count + 1}"></c:set>
                        <c:set var="total" value="${total = total + (item.electronic.price)*(item.quantity)}"></c:set>
                        <div class="order-products">
                            <div class="order-col">
                                <div>${item.quantity}x ${item.electronic.name}</div>
                                <div>
                                    <fmt:setLocale value="vi_VN"/>
                                    <fmt:formatNumber value=" ${item.electronic.price * item.quantity}"
                                                      type="currency"/>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="order-col">
                        <div>Vận chuyển</div>
                        <div><strong>FREE</strong></div>
                    </div>

                    <div class="order-col">
                        <div><strong>TOTAL</strong></div>
                        <div><strong class="order-total">
                            <fmt:setLocale value="vi_VN"/>
                            <fmt:formatNumber value=" ${total}" type="currency"/>
                        </strong></div>
                    </div>
                </div>
                <div class="payment-method">
                    <div class="input-radio">
                        <input type="radio" name="payment" id="payment-1">
                        <label for="payment-1">
                            <span></span>
                            Chuyển tiền trực tiếp qua ngân hàng
                        </label>
                        <div class="caption">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
                                incididunt ut labore et dolore magna aliqua.</p>
                        </div>
                    </div>
                    <div class="input-radio">
                        <input type="radio" name="payment" id="payment-2">
                        <label for="payment-2">
                            <span></span>
                            Thanh toán séc
                        </label>
                        <div class="caption">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
                                incididunt ut labore et dolore magna aliqua.</p>
                        </div>
                    </div>
                    <div class="input-radio">
                        <input type="radio" name="payment" id="payment-3">
                        <label for="payment-3">
                            <span></span>
                            Hệ thống Paypal
                        </label>
                        <div class="caption">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
                                incididunt ut labore et dolore magna aliqua.</p>
                        </div>
                    </div>
                </div>
                <div class="input-checkbox">
                    <input type="checkbox" id="terms">
                    <label for="terms">
                        <span></span>
                        Tôi đã đọc và chấp nhận <a href="#">Điều khoản và điều kiện</a>
                    </label>
                </div>
                <a href="/electronics" class="primary-btn order-submit">Thanh toán</a>
            </div>
            <!-- /Order Details -->
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
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/nouislider.min.js"></script>
<script src="js/jquery.zoom.min.js"></script>
<script src="js/main.js"></script>

</body>
</html>
