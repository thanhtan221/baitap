<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/1/2022
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en"><!-- Basic -->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Site Metas -->
    <title>Morning Night Cafe</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <%@include file="../assetsCustomer/layoutCustomer/header.jsp" %>

</head>

<body>
<!-- Start header -->
<%@include file="../assetsCustomer/layoutCustomer/start-header.jsp" %>
<!-- End header -->

<!-- Start slides -->
<%@include file="../assetsCustomer/layoutCustomer/start-Slides.jsp" %>
<!-- End slides -->

<!-- Start About -->
<%@include file="../assetsCustomer/layoutCustomer/start-About.jsp" %>
<!-- End About -->

<!-- Start QT -->
<%@include file="../assetsCustomer/layoutCustomer/start-QT.jsp" %>
<!-- End QT -->

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
                    <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab"
                       aria-controls="v-pills-profile" aria-selected="false">Drinks</a>
                    <a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab"
                       aria-controls="v-pills-messages" aria-selected="false">Lunch</a>
                    <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab"
                       aria-controls="v-pills-settings" aria-selected="false">Dinner</a>
                </div>
            </div>

            <div class="col-9">
                <div class="tab-content" id="v-pills-tabContent">
                    <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel"
                         aria-labelledby="v-pills-home-tab">
                        <div class="row">
                            <c:forEach var="customerList" items="${customerList}">
                                <div class="col-lg-4 col-md-2 special-grid drinks">
                                    <div class="gallery-single fix">
                                        <img src="<c:out value="${customerList.image}"/>" class="img-fluid" alt="Image">
                                        <div class="why-text">
                                            <h4><c:out value="${customerList.drinks}"/></h4>
                                            <p> Price : <c:out value="${customerList.price}"/> Đ</p>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>

                    </div>

                </div>
            </div>
            <!-- End Menu -->


            <%@include file="../assetsCustomer/layoutCustomer/start gallery.jsp" %>

            <%@include file="../assetsCustomer/layoutCustomer/start-Cutomer-Reviews.jsp" %>

            <%@include file="../assetsCustomer/layoutCustomer/start-contact-info.jsp" %>

            <%@include file="../assetsCustomer/layoutCustomer/footer.jsp" %>
</body>
</html>
