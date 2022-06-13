<!-- start page title -->
<div class="row">
    <div class="col-12">
        <div class="page-title-box">
            <div class="page-title-right">
                <ol class="breadcrumb m-0">
                    <li class="breadcrumb-item"><a href="javascript: void(0);">Simulor</a></li>
                    <li class="breadcrumb-item active">Dashboard</li>
                </ol>
            </div>
            <h4 class="page-title">Dashboard</h4>
        </div>
    </div>
</div>
<!-- end page title -->

<div class="row">
    <div class="col-xl-3 col-lg-6">
        <div class="card widget-flat">
            <div class="card-body p-0">
                <div class="p-3 pb-0">
                    <div class="float-right">
                        <i class="mdi mdi-cart text-primary widget-icon"></i>
                    </div>
                    <h5 class="text-muted font-weight-normal mt-0">Total Sales</h5>
                    <h3 class="mt-2">3,543</h3>
                </div>
                <div id="sparkline1"></div>
            </div>
        </div>
    </div>

    <div class="col-xl-3 col-lg-6">
        <div class="card widget-flat">
            <div class="card-body p-0">
                <div class="p-3 pb-0">
                    <div class="float-right">
                        <i class="mdi mdi-currency-usd text-danger widget-icon"></i>
                    </div>
                    <h5 class="text-muted font-weight-normal mt-0">Income amounts</h5>
                    <h3 class="mt-2">21,287</h3>
                </div>
                <div id="sparkline2"></div>
            </div>
        </div>
    </div>
    <c:forEach var="userList" items="${userList}">
    <div class="col-xl-3 col-lg-6">
        <div class="card widget-flat">
            <div class="card-body p-0">
                <div class="p-3 pb-0">
                    <div class="float-right">
                        <i class="mdi mdi-account-multiple text-primary widget-icon"></i>
                    </div>
                    <h5 class="text-muted font-weight-normal mt-0">Total Users</h5>
                    <h3 class="mt-2"><c:out value="${userList.totaluser}"/></h3>
                </div>
                <div id="sparkline3"></div>
            </div> <!-- end card-body-->
        </div> <!-- end card-->
    </div> <!-- end col-->
    </c:forEach>
    <div class="col-xl-3 col-lg-6">
        <div class="card widget-flat">
            <div class="card-body p-0">
                <div class="p-3 pb-0">
                    <div class="float-right">
                        <i class="mdi mdi-eye-outline text-danger widget-icon"></i>
                    </div>
                    <h5 class="text-muted font-weight-normal mt-0">Total Visits</h5>
                    <h3 class="mt-2">74,315</h3>
                </div>
                <div id="sparkline4"></div>
            </div>
        </div>
    </div>
</div>