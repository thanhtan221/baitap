<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/8/2022
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"><script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

</head>
<body>
<style type="text/css">


    @media screen and (max-width: 600px) {
        table#cart tbody td .form-control {
            width:20%;
            display: inline !important;
        }

        .actions .btn {
            width:36%;
            margin:1.5em 0;
        }

        .actions .btn-info {
            float:left;
        }

        .actions .btn-danger {
            float:right;
        }

        table#cart thead {
            display: none;
        }

        table#cart tbody td {
            display: block;
            padding: .6rem;
            min-width:320px;
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
            display:block;
        }
        table#cart tfoot td .btn {
            display:block;
        }
    }</style>
<h2 class="text-center">Giỏ Hàng Cafe Đêm Mai</h2>
<div class="container">
    <table id="cart" class="table table-hover table-condensed">
        <thead>
        <tr>
            <th style="width:50%">Drinks</th>
            <th style="width:10%">Price</th>
            <th style="width:8%" class="text-center">Quantity</th>
            <th style="width:22%" class="text-center">Cash</th>
            <th style="width:10%"> </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customerList" items="${customerList}">
        <tr>
            <input type="hidden" class="form-control" id="validationTooltip1" name="id"
                   placeholder="Full Name" value="<c:out value='${customerList.id}'/>" required="">
            <td data-th="Product">
                <div class="row">
                    <div class="col-sm-2 hidden-xs"><img src="<c:out value="${customerList.image}"/>" alt="Sản phẩm 1" class="img-responsive" width="100">
                    </div>
                    <div class="col-sm-10">
                        <h4 class="nomargin"><c:out value="${customerList.drinks}"/></h4>
                    </div>
                </div>
            </td>

            <td data-th="Price"><fmt:formatNumber type="currency" pattern="#,###" value="${customerList.price}"/> đ</td>
            <td data-th="Quantity" class="text-center" ><c:out value="${customerList.quantity}"/></td>
            <td data-th="Subtotal" class="text-center" name="cash"><fmt:formatNumber type="currency" pattern="#,###" value="${customerList.cash}"/> đ</td>
            <td class="actions" data-th="">
                <a href="/cart?action=editcart&id=${customerList.id}"><i class="fa-solid fa-plus"></i></a>
                </td>
            <td class="actions" data-th="">
            <a href="/cart?action=deletedcart&id=${customerList.id}"><i class="fa-solid fa-trash"></i></a>
            </td>
            <td></td>
            <td class="actions" data-th="">
                <a href="/cart?action=addbill&id=${customerList.id}"><i class="fa-solid fa-comment-dollar"></i></a>
            </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
        <td><a href="customer?action=menucustomer" class="btn btn-warning"><i class="fa fa-angle-left"></i> Tiếp tục mua hàng</a>
        </td>
        <td colspan="2" class="hidden-xs">Tổng Tiền :  </td>
                <c:forEach var="customerLists" items="${customerLists}">
        <td class="hidden-xs text-center"> <strong><fmt:formatNumber type="currency" pattern="#,###" value="${customerLists.total}"/> đ</strong>
        </td>
                </c:forEach>
        <td><a href="http://hocwebgiare.com/" class="btn btn-success btn-block">Thanh toán <i class="fa fa-angle-right"></i></a>
        </td>
    </tr>
    </tfoot>
    </table>
</div>
</body>
</html>
