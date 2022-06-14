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

    <!-- left-side-menu -->

    <%@include file="../assets/layout/left-side-menu.jsp" %>

    <!-- left-side-menu -->

    <div class="content-page">
        <div class="content">

            <!-- Start Content-->
            <div class="container-fluid">

                <!-- DashBoard -->

                <%@include file="../assets/layout/dashboard.jsp" %>

                <!-- DashBoard -->

                <!-- connent -->

                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="header-title">Recent Customers</h4>

                                <div class="table-responsive mt-3">
                                    <table class="table table-hover table-centered mb-0">
                                        <thead>
                                        <tr>
                                            <th>User ID</th>
                                            <th>Basic Info</th>
                                            <th>Phone</th>
                                            <th>Address</th>
                                            <th>City</th>
                                            <th>Role</th>
                                            <th>Action</th>
                                        </tr>
                                        </thead>

                                        <c:forEach var="listuser" items="${listUser}">
                                            <tbody>

                                            <tr>

                                                <th scope="row"><c:out value="${listuser.id}"/></th>
                                                <td>

                                                    <div class="overflow-hidden">
                                                        <p class="mb-0 font-weight-medium"><a href="javascript: void(0);"><c:out value="${listuser.name}"/></a></p>
                                                        <span class="font-13"><c:out value="${listuser.email}"/></span>
                                                    </div>
                                                </td>

                                                <td><c:out value="${listuser.phone}"/></td>

                                                <td><c:out value="${listuser.address}"/></td>

                                                <td><c:out value="${listuser.city}"/></td>

                                                <td><c:out value="${listuser.role}"/></td>

                                                <td>
                                                    <div class="btn-group dropdown">
                                                        <a href="javascript: void(0);"
                                                           class="dropdown-toggle arrow-none btn btn-light btn-sm"
                                                           data-toggle="dropdown" aria-expanded="false"><i
                                                                class="mdi mdi-dots-horizontal"></i></a>
                                                        <div class="dropdown-menu dropdown-menu-right">
                                                            <a class="dropdown-item" href="${pageContext.request.contextPath}/unlock?action=unlock&id=${listuser.id}"><i
                                                                    class="mdi mdi-delete mr-1 text-muted"></i>Remove</a>
                                                        </div>
                                                    </div>
                                                </td>

                                            </tr>
                                            </tbody>
                                        </c:forEach>
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
