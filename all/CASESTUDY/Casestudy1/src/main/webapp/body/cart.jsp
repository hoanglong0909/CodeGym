<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Title</title>
    <style type="text/css">


        @media screen and (max-width: 600px) {
            table#cart tbody td .form-control {
                width: 20%;
                display: inline !important;
            }

            .actions .btn {
                width: 36%;
                margin: 1.5em 0;
            }

            .actions .btn-info {
                float: left;
            }

            .actions .btn-danger {
                float: right;
            }

            table#cart thead {
                display: none;
            }

            table#cart tbody td {
                display: block;
                padding: .6rem;
                min-width: 320px;
            }

            table#cart tbody tr td:first-child {
                background: #333;
                color: #fff;
            }

            table#cart tbody td:before {
                content: attr(data-th);
                font-weight: bold;
                display: inline-block;
                width: 8rem;
            }

            table#cart tfoot td {
                display: block;
            }

            table#cart tfoot td .btn {
                display: block;
            }
        }</style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <script src="js/jquery-1.11.1.min.js"></script>
</head>
<body>
<h2 class="text-center">Gi??? h??ng c???a b???n</h2>
<div class="container">
    <table id="cart" class="table table-hover table-condensed">
        <thead>
        <tr>
            <th style="width:50%">T??n s???n ph???m</th>
            <%--            <th style="width:25%">???nh</th>--%>
            <th style="width:10%">Gi??</th>
            <th style="width:8%">S??? l?????ng</th>
            <th style="width:22%" class="text-center">Th??nh ti???n</th>
            <th style="width:10%"></th>
        </tr>
        </thead>
        <tbody>
        <c:set var="total" value="${total = 0}"></c:set>
        <c:forEach items="${order.items}" var="item">
        <c:set var="total" value="${total = total + (item.electronic.price)*(item.quantity)}"></c:set>
        <tr>
            <td data-th="Product">
                <div class="row">
                    <div class="col-sm-2 hidden-xs">
                        <img src="${item.electronic.image}" alt="S???n ph???m 1" class="img-responsive" width="100">
                    </div>
                    <div class="col-sm-10">
                        <h4 class="nomargin">${item.electronic.name}</h4>
                        <p>M?? t??? c???a s???n ph???m 2</p>
                    </div>
                </div>
            </td>
            <td data-th="Price">
                <fmt:setLocale value="vi_VN"/>
                <fmt:formatNumber value="${item.electronic.price}" type="currency"/>
            </td>
            <td data-th="Quantity">
                <input class="form-control text-center" value="${item.quantity}" type="number">
            </td>
            <td data-th="Subtotal" class="text-center">
                <fmt:setLocale value="vi_VN"/>
                <fmt:formatNumber value=" ${item.electronic.price * item.quantity}" type="currency"/>
            </td>
            <td class="actions" data-th="">
                <button class="btn btn-info btn-sm"><i class="fa fa-edit"></i></button>
                <button class="btn btn-danger btn-sm">
                    <a href="/delete?action=deleteCart&id=${item.electronic.id}">
                        <i class="fas fa-trash-alt"></i>
                    </a>
                </button>
            </td>
        </tr>
        </tbody>
        </c:forEach>
        <tr>
            <td><strong>T???ng ti???n</strong></td>
            <td colspan="2" class="hidden-xs"></td>
            <td class="hidden-xs text-center"><strong>
                <fmt:setLocale value="vi_VN"/>
                <fmt:formatNumber value="${total}" type="currency"/>
            </strong>
            </td>
            <td>
            </td>
        </tr>
        </tfoot>
        <tfoot>
        <tr>
            <td><a href="/electronics" class="btn btn-warning"><i class="fa fa-angle-left"></i> Ti???p t???c mua h??ng</a>
            </td>
            <td colspan="2" class="hidden-xs"></td>
            <td class="hidden-xs text-center">
            </td>
            <td><a href="bill.jsp" class="btn btn-success btn-block">Thanh to??n <i class="fa fa-angle-right"></i></a>
            </td>
        </tr>
        </tfoot>
    </table>
</div>
</body>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</html>
