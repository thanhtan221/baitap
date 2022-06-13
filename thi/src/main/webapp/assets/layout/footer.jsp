<footer class="footer">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6">
                2018 - 2019 &copy; Simulor theme by <a href="">Coderthemes</a>
            </div>
            <div class="col-md-6">
                <div class="text-md-right footer-links d-none d-sm-block">
                    <a href="#">About Us</a>
                    <a href="#">Help</a>
                    <a href="#">Contact Us</a>
                </div>
            </div>
        </div>
    </div>
</footer>

<div class="footer">
    <div id="message-alert">
        <c:if test="${requestScope.color == 1}">
                <script>
                    iziToast.success({
                        title: 'Hey',
                        message: ' ${message}',
                        position : 'topRight'
                    });
                </script>
            </div>
        </c:if>
        <c:if test="${requestScope.color == 0}">
            <script>
                iziToast.error({
                title: 'Hey',
                message: ' ${message}',
                    position : 'topRight'
            });
            </script>
        </c:if>
    </div>
</div>