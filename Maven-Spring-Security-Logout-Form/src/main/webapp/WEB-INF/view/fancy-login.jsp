<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>

<title>Bootstrap Login Page</title>

<!--  Adding the styles for my bootstrap form -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!--  My Logging Page CSS styles -->
<link rel="stylesheet" type="text/css" href="css/myLoginPage.css">

</head>

<body>
	<div class="login-form">
		<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
			<h2 class="text-center">Log in</h2>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Username" name="username" required="required">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" placeholder="Password" name="password" required="required">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block">Log in</button>
				<br>
				<!-- Alert for Error Message -->
				<c:if test="${param.error != null}">
					<div class="alert alert-danger alert-dismissible fade show" role="alert">
						<strong>Sorry!</strong>
						You entered an invalid user/password.
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:if>
				<!-- Alert for Success Message -->

				<!-- Checking for logout -->
				<c:if test="${param.logout != null}">
					<div class="alert alert-success alert-dismissible fade show" role="alert">
						<strong>Logout!</strong>
						You have been logged out.
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</c:if>



			</div>
			<div class="clearfix">
				<label class="float-left form-check-label">
					<input type="checkbox">
					Remember me
				</label>
				<a href="#" class="float-right">Forgot Password?</a>
			</div>
		</form:form>
		<p class="text-center">
			<a href="#">Create an Account</a>
		</p>
	</div>
</body>

</html>












