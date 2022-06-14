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
    <div id="wrapper ">
        <div class="container-fluid">
            <div class="col-lg-12">
                <div class="card">
                    <div class="card-body">
                        <div class="table-responsive mt-3">
                            <form class="needs-validation" novalidate="" method="post">
                                <div class="form-group position-relative mb-3">
                                    <label for="validationTooltip02">USER_ID</label>
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                        </div>
                                        <input type="text" class="form-control" id="validationTooltip02" name="user_id"
                                               placeholder="Drinks" value="" required="">

                                    </div>
                                </div>
                                <div class="form-group position-relative mb-3">

                                    <div class="mb-3 col-md-3">
                                        <label for="validationTooltip05" class="col-sm-12 col-form-label">CART ID</label>
                                        <select id="validationTooltip05" class="form-select" name="cart_id" >

                                            <c:forEach var="customerList" items="${customerList}">

                                                <option value="<c:out value="${customerList.id}"/>">

                                                    <c:out value='${customerList.id}'/>

                                                </option>

                                            </c:forEach>

                                        </select>
                                    </div>
                                </div>

                                <div class="form-group position-relative mb-3">
                                    <label for="validationTooltip05">Tiền Gửi</label>
                                    <input type="text" class="form-control" id="validationTooltip0" name="tien_gui"
                                           placeholder="tien_gui" required="">

                                </div>

                                <button class="btn btn-primary" type="submit">Submit form</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
