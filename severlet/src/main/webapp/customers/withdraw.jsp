<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Withdraw</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="/layout/header.jsp" %>

</head>
<body>
<div class="container">
    <div class="table-title mb-4">
        <div class="row">
            <div class="col-sm-8">
                <h2>Withdraw money into customer's account</h2>
            </div>
            <div class="col-sm-4">
                <a href="/customers" class="btn btn-outline-light"><i class="fa fa-list" aria-hidden="true"></i> <span>Customer list</span></a>
            </div>
        </div>
    </div>
    <form id="frmDeposit" method="post" >
        <fieldset class="row g-3">
            <div class="col-md-6">
                <label class="form-label">ID</label>
                <input type="text" class="form-control" readonly id="id" name="id" value="<c:out value='${Customers.id}'/>">
            </div>
            <div class="mb-3 col-md-6">
                <div class="form-group row">
                    <label class="col-sm-12 col-form-label">Full Name</label>
                    <div class="col-sm-12">
                        <input type="text" class="form-control" readonly id="fullName" name="fullName" value="<c:out value='${Customers.full_name}'/>" />
                    </div>
                </div>
            </div>
            <div class="mb-3 col-md-6">
                <div class="form-group row">
                    <label class="col-sm-12 col-form-label">Current balance ($)</label>
                    <div class="col-sm-12">
                        <input type="text" class="form-control num-space" readonly id="balance" name="balance" value="<c:out value='${Customers.balance}'/>" />
                    </div>
                </div>
            </div>
            <div class="mb-3 col-md-6">
                <div class="form-group row">
                    <label class="col-sm-12 col-form-label">Transaction Amount ($)</label>
                    <div class="col-sm-12">
                        <input type="text" class="form-control" id="transactionAmount" name="transactionAmount" value="" />
                    </div>
                </div>
            </div>

            <div class="mb-3 col-md-12">
                <div class="form-group row">
                    <div class="col-sm-4">
                        <button type="submit" class="btn btn-outline-success">
                            <i class="fa fa-plus" aria-hidden="true"></i>
                            Withdraw
                        </button>
                    </div>
                </div>
            </div>


        </fieldset>
    </form>
</div>
<div class="footer">
    <div id="message-alert">


        <div class="alert-danger hide">
            <h5>Please correct errors below:</h5>
        </div>

    </div>
</div>
<%@include file="/layout/script.jsp"%>
</body>
</html>
