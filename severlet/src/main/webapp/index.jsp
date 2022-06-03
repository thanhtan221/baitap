
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Customer management</title>


    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="/layout/header.jsp" %>

</head>
<body>
<div class="container">
    <div class="table-title">
        <div class="row">
            <div class="col-sm-5">
                <h1>List of customers</h1>
            </div>
            <div class="col-sm-7">
                <a href="/customers?action=AddCustomers" class="btn btn-outline-light"><i class="fa fa-plus-square-o" aria-hidden="true"></i> <span>Add New Customer</span></a>
                <a href="#" class="btn btn-outline-light"><i class="fa fa-history" aria-hidden="true"></i> <span>Transfer money Information</span></a>
            </div>
        </div>
    </div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>#</th>
            <th>FullName</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Balance</th>
            <th colspan="5">Action</th>
        </tr>
        </thead>
        <tbody>
<%--        <% DecimalFormat formatter = new DecimalFormat("###,###,###");--%>
<%--            Long balance = Long.valueOf(request.getParameter("balance"));--%>
<%--        %>--%>
<%--        <%= formatter.format(balance) + " VNĐ " %>--%>
        <c:forEach var="Customers" items="${customersList}">
            <tr>
                <td><c:out value="${Customers.id}"/></td>
                <td><c:out value="${Customers.full_name}"/></td>
                <td><c:out value="${Customers.email}"/></td>
                <td><c:out value="${Customers.phone}"/></td>
                <td><c:out value="${Customers.address}"/></td>
                <td name="balance"> <c:out value="${Customers.balance}"/></td>

                <td class="button" >
                    <a class="btn btn-outline-secondary" href="/customers?action=EditCustomers&id=${Customers.id}" title="Edit" data-toggle="tooltip" data-bs-original-title="Edit"   >
                        <i class="fa fa-pencil-square-o"></i></a>
                </td>
                <td class="button">
                    <a class="btn btn-outline-success" href="/customers?action=DepositCustomers&id=${Customers.id}" title="Deposit" data-toggle="tooltip" data-bs-original-title="Deposit"   >
                        <i class="fa fa-plus"></i></a>
                </td>
                <td class="button">
                    <a class="btn btn-outline-warning" href="/customers?action=withdraw&id=${Customers.id}" title="Withdraw" data-toggle="tooltip" data-bs-original-title="Withdraw">
                        <i class="fa fa-minus"></i></a>
                </td>
                <td class="button">
                    <a class="btn btn-outline-primary" href="/customers?action=Transfer&id=${Customers.id}" title="Transfer" data-toggle="tooltip" data-bs-original-title="Transfer">
                        <i class="fa fa-exchange"></i></a>
                </td>
                <td class="button">
                    <a class="btn btn-outline-danger" href="/customers?action=delete&id=${Customers.id}" title="Suspended" data-toggle="tooltip" data-bs-original-title="Suspended">
                        <i class="fa fa-ban"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


<%@include file="/layout/script.jsp"%>
</body>
</html>