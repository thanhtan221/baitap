<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Simulor - Responsive Bootstrap 4 Admin Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description">
    <meta content="Coderthemes" name="author">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%@include file="../assets/layout/header.jsp" %>
    <script src="/assets/message/js/iziToast.min.js"></script>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

</head>

<body>
<div id="wrapper">
    <div class="navbar-custom">
        <ul class="list-unstyled topnav-menu float-right mb-0">

            <%@include file="../assets/layout/notification-list.jsp" %>

            <%@include file="../assets/layout/notification.jsp" %>

        </ul>
        <%@include file="../assets/layout/menu-left.jsp" %>
    </div>

    <%@include file="../assets/layout/left-side-menu.jsp" %>
    <div class="content-page">
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="header-title">Recent Customers</h4>

                                <div class="table-responsive mt-3">
                                    <table class="table table-hover table-centered mb-0">
                                        <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Date</th>
                                            <th>name</th>
                                            <th>Drinks</th>
                                            <th>Price</th>
                                            <th>Quantity</th>
                                            <th>Send money</th>
                                            <th>oder</th>
                                            <th>Money Balance</th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="billList" items="${billList}">
                                            <tr>


                                                <td><c:out value='${billList.id_bill}'/></td>
                                                <td><c:out value="${billList.dateExport}"/></td>

                                                <td><c:out value="${billList.name}"/></td>

                                                <td><c:out value="${billList.drinks}"/></td>

                                                <td> <fmt:formatNumber type="currency" pattern="#,###" value="${billList.price}"/> đ</td>
                                                <td><c:out value="${billList.quantity}"/></td>
                                                <td><fmt:formatNumber type="currency" pattern="#,###" value="${billList.tien_gui}"/> đ</td>
                                                <td><fmt:formatNumber type="currency" pattern="#,###" value="${billList.oder}"/> đ</td>
                                                <td> <fmt:formatNumber type="currency" pattern="#,###" value="${billList.tien_du}"/> đ</td>
                                                <td>
                                                    <div class="btn-group dropdown">
                                                        <a href="javascript: void(0);"
                                                           class="dropdown-toggle arrow-none btn btn-light btn-sm"
                                                           data-toggle="dropdown" aria-expanded="false"><i
                                                                class="mdi mdi-dots-horizontal"></i></a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <a class="dropdown-item"
                                                               href=""><i
                                                                    class="mdi mdi-pencil mr-1 text-muted"></i>Edit
                                                                Contact</a>
                                                            <a class="dropdown-item"
                                                               href=""><i
                                                                    class="mdi mdi-delete mr-1 text-muted"></i>Remove</a>
                                                        </div>
                                                    </div>
                                                </td>

                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <%@include file="../assets/layout/footer.jsp" %>

    </div>

</div>

<%@include file="../assets/layout/right-bar.jsp" %>

<div class="rightbar-overlay"></div>
<%@include file="../assets/layout/script.jsp" %>

</body>
</html>
