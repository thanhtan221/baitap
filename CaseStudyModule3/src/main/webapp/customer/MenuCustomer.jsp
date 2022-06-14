
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en"><!-- Basic -->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Site Metas -->
    <title>Live Dinner Restaurant - Responsive HTML5 Template</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <%@include file="../assetsCustomer/layoutCustomer/header.jsp" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

</head>

<body>
<!-- Start header -->
<%@include file="../assetsCustomer/layoutCustomer/start-header.jsp" %>
<!-- End header -->

<!-- Start All Pages -->
<div class="all-page-title page-breadcrumb">
    <div class="container text-center">
        <div class="row">
            <div class="col-lg-12">
                <h1>Special Menu</h1>
            </div>
        </div>
    </div>
</div>
<!-- End All Pages -->

<!-- Start Menu -->
<div class="menu-box">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="heading-title text-center">
                    <h2>Special Menu</h2>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting</p>
                </div>
            </div>
        </div>

        <div class="row inner-menu-box">
            <div class="col-3">
                <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab"
                       aria-controls="v-pills-home" aria-selected="true">All</a>
                </div>
            </div>


            <div class="col-9">
                <div class="tab-content" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel"
                         aria-labelledby="v-pills-home-tab">
                        <form method="post">
                            <div class="row">
                                <c:forEach var="customerList" items="${customerList}">
                                    <div class="col-lg-4 col-md-2 special-grid drinks">
                                        <a href="customer?action=addCart&id=${customerList.id}">
                                            <div class="gallery-single fix">
                                                <img src="<c:out value="${customerList.image}"/>" class="img-fluid"
                                                     alt="Image">
                                                <div class="why-text">
                                                    <h4 name="id"><c:out value="${customerList.id}"/></h4>
                                                    <h4><c:out value="${customerList.drinks}"/></h4>
                                                    <p> Price : <fmt:formatNumber type="currency" pattern="#,###" value="${customerList.price}"/> đ</p>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                </c:forEach>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Menu -->

<!-- Start QT -->
<%@include file="../assetsCustomer/layoutCustomer/start-QT.jsp" %>
<!-- End QT -->

<!-- Start Customer Reviews -->
<%@include file="../assetsCustomer/layoutCustomer/start-Cutomer-Reviews.jsp" %>
<!-- End Customer Reviews -->

<!-- Start Contact info -->
<%@include file="../assetsCustomer/layoutCustomer/start-contact-info.jsp" %>
<!-- End Contact info -->

<%@include file="../assetsCustomer/layoutCustomer/footer.jsp" %>
</body>
</html>