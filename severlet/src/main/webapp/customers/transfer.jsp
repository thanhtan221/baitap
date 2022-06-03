<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Transfer</title>


    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="/layout/header.jsp" %>

</head>
<body>
<div class="container">
    <div class="table-title mb-4">
        <div class="row">
            <div class="col-sm-6">
                <h1>Transfer money Information</h1>
            </div>
            <div class="col-sm-6">
                <a href="/customers" class="btn btn-outline-light"><i class="fa fa-list" aria-hidden="true"></i> <span>Customer list</span></a>
            </div>
        </div>
    </div>
    <form id="frmTransfer" method="post">
        <fieldset class="row g-3">
            <div class="form-group row">
                <c:if test="${Customers != null}">
                    <div class="mb-3 col-md-3">
                        <label class="col-sm-12 col-form-label" for="validationTooltip01">Sender ID</label>
                        <div class="col-sm-12">
                            <input type="text" class="form-control" readonly id="validationTooltip01" name="senderId"
                                   value="<c:out value="${Customers.id}"/>">
                        </div>
                    </div>
                </c:if>

                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label " for="validationTooltip02">Sender Name</label>
                    <div class="col-sm-12">
                        <input type="text" class="form-control" readonly id="validationTooltip02" name="senderName"
                               value="<c:out value="${Customers.full_name}"/>">
                    </div>
                </div>
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label" for="validationTooltip03">Email</label>
                    <div class="col-sm-12">
                        <input type="email" class="form-control" readonly id="validationTooltip03" name="email"
                               value="<c:out value="${Customers.email}"/>">
                    </div>
                </div>
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label" for="validationTooltip04">Sender balance</label>
                    <div class="col-sm-12">
                        <input type="text" class="form-control num-space" readonly id="validationTooltip04" name="balance"
                               value="<c:out value="${Customers.balance}"/>">
                    </div>
                </div>
            </div>
            <div class="form-group row mb-4">
                <div class="mb-3 col-md-3">
                    <label for="validationTooltip05" class="col-sm-12 col-form-label">Recipient Name</label>
                        <select id="validationTooltip05" class="form-select" name="RecipientId" >

                            <c:forEach var="customers" items="${customersList}">

                                <option value="<c:out value="${customers.id}"/>">

                                    <c:out value="(${customers.id})${customers.full_name}"/>

                                </option>

                            </c:forEach>

                        </select>
                </div>

                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label" for="validationTooltip06">Transfer Amount ($)</label>
                    <div class="col-sm-12">
                        <input type="text" id="validationTooltip06" class="form-control num-space" name="transferAmount"
                               value="">
                    </div>
                </div>
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label" for="validationTooltip07">Fees (%)</label>
                    <div class="col-sm-12">
                        <input type="text" class="form-control num-space" value="10" readonly id="validationTooltip07">
                    </div>
                </div>
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label"  for="validationTooltip08">Total amount of transaction ($)</label>
                    <div class="col-sm-12">
                        <input type="text" class="form-control num-space" readonly id="validationTooltip08"
                               name="transaction" value="">
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <div class="mb-3 col-md-12">
                    <div class="col-sm-4">
                        <button type="submit" class="btn btn-outline-primary">
                            <i class="fa fa-exchange" aria-hidden="true"></i>
                            Transfer
                        </button>
                    </div>
                </div>
            </div>
        </fieldset>
    </form>
</div>

<%@include file="/layout/script.jsp" %>

<div class="footer">
    <div id="message-alert">


        <div class="alert-danger hide">
            <h5>Please correct errors below FE:</h5>
        </div>

    </div>
</div>


<script>
    $(function () {
        $("#transferAmount").on("change", function () {
            let transferAmount = $(this).val();
            let fees = 10;
            let feeAmount = transferAmount * fees / 100;
            let transactionAmount = parseInt(transferAmount) + feeAmount;
            $("#transactionAmount").val(transactionAmount);
        });
    });
</script>

</body>
</html>
