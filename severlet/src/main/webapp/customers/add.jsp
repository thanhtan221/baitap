<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Create customer</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="/layout/header.jsp" %>

</head>
<body>
<div class="container">
    <div class="table-title mb-4">
        <div class="row">
            <div class="col-sm-6">
                <h1>Create customer</h1>
            </div>
            <div class="col-sm-6">
                <a href="/customers" class="btn btn-outline-light">
                    <i class="fa-solid fa-house-user"></i>
                    <span>List of customers</span>
                </a>
            </div>
        </div>
    </div>
    <form id="frmCreateCustomer" method="post">
        <fieldset class="row g-3">
            <div class="col-md-6">
                <label class="form-label">Full name</label>
                <input type="text" class="form-control" id="fullName" name="fullName" value="">
            </div>
            <div class="col-md-6">
                <label class="form-label">Email</label>
                <input type="text" class="form-control" id="email" name="email" value="">
            </div>
            <div class="col-md-6">
                <label class="form-label">Phone</label>
                <input type="tel" class="form-control" id="phone" name="phone" value="">
            </div>
            <div class="col-md-6">
                <label class="form-label">Address</label>
                <input type="text" class="form-control" id="address" name="address" value="">
            </div>
            <div class="col-md-12">
                <button type="submit" id="btnCreateCustomer" class="btn btn-outline-primary">
                    <i class="fa fa-plus" aria-hidden="true"></i>
                    Create customer
                </button>
            </div>
        </fieldset>
    </form>
</div>
<div class="footer">
    <div id="message-alert">
        <div class="alert-danger hide">
            <h5>Please correct errors below FE:</h5>
<%--        </div>--%>
<%--        <c:if test = "${successful != null}">--%>
<%--        <p style="background-color: blue; display: block">--%>
<%--        <c:out value = "${successful}"/>--%>
<%--        <p>--%>
<%--        </c:if>--%>

<%--            <c:if test = "${error = null}">--%>
<%--        <p style="background-color: greenyellow; display: block">--%>
<%--                <c:out value = "${error}"/>--%>
<%--        <p>--%>
<%--           <div>--%>
<%--        </c:if>--%>
<%--        <c:if test = "${successfuls != null}">--%>
<%--        <p style="background-color: blue; display: block">--%>
<%--                <c:out value = "${successfuls}"/>--%>
<%--        <p>--%>
<%--            </c:if>--%>
<%--            <c:if test = "${successfulss != null}">--%>
<%--        <p style="background-color: greenyellow; display: block">--%>
<%--                <c:out value = "${successfulss}"/>--%>
<%--            </c:if>--%>
<%--           </div>--%>
    </div>
</div>
<%@include file="/layout/script.jsp"%>
</body>
</html>
