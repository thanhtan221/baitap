<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>RegistrationForm_v8 by Colorlib</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="/login/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
		
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="/login/css/style.css">
	</head>
<style>	
.img{
	height: 100%;
}
</style>
	<body>
		<div class="wrapper">
			<div class="">
				<img  class="img" src="/login/images/hinh-anh-quan-cafe-dep-nhat-1.jpg" alt="">
			</div>
			<div class="form-inner">
				<form action="" method="post">
					<div class="form-header">
						<h3>Sign up</h3>
						<img src="/login/images/sign-up.png" alt="" class="sign-up-icon">
					</div>
					<div class="form-group">
						<label >Username:</label>
						<input type="text" class="form-control" data-validation="length alphanumeric" data-validation-length="3-12" name="name">
					</div>
					<div class="form-group">
						<label >E-mail:</label>
						<input type="text" class="form-control" data-validation="email" name="email">
					</div>
					<div class="form-group" >
						<label >Password:</label>
						<input type="password" class="form-control" data-validation="length" data-validation-length="" name="password">
					</div>
					<button>create my account</button>
					<div class="socials">
						<p>Sign up with social platforms</p>
						<a href="" class="socials-icon">
							<i class="zmdi zmdi-facebook"></i>
						</a>
						<a href="" class="socials-icon">
							<i class="zmdi zmdi-instagram"></i>
						</a>
						<a href="" class="socials-icon">
							<i class="zmdi zmdi-twitter"></i>
						</a>
						<a href="" class="socials-icon">
							<i class="zmdi zmdi-tumblr"></i>
						</a>
					</div>
				</form>
			</div>
			
		</div>
		
		<script src="/login/js/jquery-3.3.1.min.js"></script>
		<script src="/login/js/jquery.form-validator.min.js"></script>
		<script src="/login/js/main.js"></script>
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>