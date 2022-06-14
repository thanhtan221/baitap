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
    <%@include file="/assets/layout/header.jsp" %>
    <script src="/assets/message/js/iziToast.min.js"></script>

</head>

<body>
<div id="wrapper">
    <div class="navbar-custom">
        <ul class="list-unstyled topnav-menu float-right mb-0">
q
            <%@include file="/assets/layout/notification-list.jsp" %>

            <%@include file="/assets/layout/notification.jsp" %>

        </ul>

        <%@include file="/assets/layout/menu-left.jsp" %>
    </div>

    <!-- left-side-menu -->

    <%@include file="/assets/layout/left-side-menu.jsp" %>

    <!-- left-side-menu -->

    <div class="content-page">
        <div class="content">

            <!-- Start Content-->
            <div class="container-fluid">

                <!-- DashBoard -->

                <%@include file="/assets/layout/dashboard.jsp" %>

                <!-- DashBoard -->

                <!-- connent -->

                <div id="wrapper ">
                    <div class="container-fluid">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="table-responsive mt-3">
                                            <form class="needs-validation" novalidate="" method="post">
                                                <div class="form-group position-relative mb-3">
                                                    <label for="validationTooltip01">Full Name</label>
                                                    <input type="text" class="form-control" id="validationTooltip01" name="name"
                                                           placeholder="Full Name" value="" required="" pattern="^([A-Z]+[a-z]*[ ]?)+$">
                                                    <div class="valid-tooltip">
                                                        Looks good!
                                                    </div>
                                                    <div class="invalid-tooltip">
                                                        Please enter first name.
                                                    </div>
                                                </div>
                                                <div class="form-group position-relative mb-3">
                                                    <label for="validationTooltip02">Email</label>
                                                    <div class="input-group">
                                                        <div class="input-group-prepend">
                                                        <span class="input-group-text"
                                                              >@</span>
                                                        </div>
                                                        <input type="text" class="form-control" id="validationTooltip02" name="email"
                                                               placeholder="Email" value="" required="" >
                                                        <div class="valid-tooltip">
                                                            Looks good!
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group position-relative mb-3">
                                                    <label for="validationTooltipUsername">Password</label>
                                                    <div class="form-group position-relative mb-3">
                                                        <input type="text" class="form-control"
                                                               id="validationTooltipUsername" placeholder="Password"
                                                               aria-describedby="validationTooltipUsernamePrepend" name="password"
                                                               required="">
                                                        <div class="invalid-tooltip">
                                                            Please choose a unique and valid Password.
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="form-group position-relative mb-3">
                                                    <label for="validationTooltip0">phone</label>
                                                    <input type="text" class="form-control" id="validationTooltip0" name="phone"
                                                           placeholder="Address" required="" >
                                                    <div class="invalid-tooltip">
                                                        Please provide a valid phone.
                                                    </div>
                                                </div>
                                                <div class="form-group position-relative mb-3">
                                                    <label for="validationTooltip04">Address</label>
                                                    <input type="text" class="form-control" id="validationTooltip05" name="address"
                                                           placeholder="Address" required="" >
                                                    <div class="invalid-tooltip">
                                                        Please provide a valid Address.
                                                    </div>
                                                </div>
                                                <div class="form-group position-relative mb-3">
                                                    <label for="validationTooltip04">City</label>
                                                    <input type="text" class="form-control" id="validationTooltip04" name="city"
                                                           placeholder="City" required="" >
                                                    <div class="invalid-tooltip">
                                                        Please provide a valid City.
                                                    </div>
                                                </div>
                                                <div class="form-group position-relative mb-3">
                                                    <label for="validationTooltip05">Role</label>
                                                    <input type="text" class="form-control" id="validationTooltip06" name="role"
                                                           placeholder="ADMIN" required="">
                                                    <div class="invalid-tooltip">
                                                        Please provide a valid Role.
                                                    </div>
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

        </div>


        <!-- Footer Start -->
        <%@include file="/assets/layout/footer.jsp" %>

    </div>

</div>

<%@include file="/assets/layout/right-bar.jsp" %>

<div class="rightbar-overlay"></div>
<%@include file="/assets/layout/script.jsp" %>

</body>
</html>
