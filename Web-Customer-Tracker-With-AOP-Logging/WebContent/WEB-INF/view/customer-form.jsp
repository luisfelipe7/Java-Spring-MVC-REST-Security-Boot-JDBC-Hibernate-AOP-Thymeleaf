<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>CRM</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Importing JQuery -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<!-- Adding the JS File to load the modal -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/test.js"></script>

<!--  Importing CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css" />

</head>

<body>
	<!-- Fixed navbar -->
	<nav class="navbar navbar-fixed-top colorNavbar">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/Web-Customer-Tracker/index.jsp">Welcome!</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="nonactive">
						<a onclick="window.location.href='list'" class="colorLink">Customers List</a>
					</li>
					<c:if test="${type == 'add'}">
						<li class="active">
							<a onclick="window.location.href='showFormForAdd'" class="colorLink">Add Customer</a>
						</li>
					</c:if>
					<c:if test="${type == 'edit'}">
						<li class="nonactive">
							<a onclick="window.location.href='showFormForAdd'" class="colorLink">Add Customer</a>
						</li>
					</c:if>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container theme-showcase" role="main">

		<!-- Main jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h2>
				<b>CRM - Customer Relationship Manager</b>
			</h2>
			<p>With this technology you can manage all your company's relationships and interactions with customers and potential customers. The goal is simple: Improve relationships to grow your business</p>
		</div>
		<div class="page-header">
			<c:if test="${type == 'add'}">
				<h1>Adding a new customer</h1>
			</c:if>
			<c:if test="${type == 'edit'}">
				<h1>Updating a customer</h1>
			</c:if>
			<br>
			<!-- Creating a form to post the data and do the search -->
			<form:form action="saveCustomer" modelAttribute="customer" method="POST">
				<form:hidden path="id"/>
				<div class="form-group">
					<label for=formGroupExampleInput>First Name</label>
					<form:input path="firstName" type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter first name" minlength="3" maxlength="200" required="required" />
				</div>
				<div class="form-group">
					<label for=formGroupExampleInput2>Last Name</label>
					<form:input path="lastName" type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter last name" minlength="3" maxlength="200" required="required" />
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label>
					<form:input path="email" type="email" class="form-control" id="email" name="email" placeholder="Enter email" minlength="7" maxlength="200" required="required" />
					<small id="email" class="form-text text-muted">We'll never share your email or any information with anyone else outside of the university</small>
				</div>
				<c:if test="${type == 'add'}">
					<button type="submit" value="Save" class="btn btn-success save">Add Customer</button>
				</c:if>
				<c:if test="${type == 'edit'}">
					<button type="submit" value="Save" class="btn btn-info save">Update Customer</button>
				</c:if>
			</form:form>
			<br>
		</div>

	</div>
	<!-- /container -->

</body>

</html>