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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/sortable-table.js"></script>

<!--  Importing CSS -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/sortable-table.css" />

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
					<li class="active">
						<a href="" class="colorLink">Customers List</a>
					</li>
					<li class="nonactive">
						<a onclick="window.location.href='showFormForAdd'" class="colorLink">Add Customer</a>
					</li>
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
			<h1>List of Customers</h1>
			<br>
			<!-- Creating a form to post the data and do the search -->
			<form action="searchByName" method="POST">
				<!-- HIDDEN FIELD TO SAVE IN COMMAND THE ACTION ADD-->
				<input type="hidden" name="command" value="SEARCH" />
				<input type="text" class="inputlg col-xs-5 widthSearch" name="nameToSearch" placeholder="Enter the name that you want to search">
				<button type="submit" class="btn btn-primary">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"></path>
</svg>
				</button>
			</form>
			<br>
		</div>
		<div class="row">
			<div class="col-md-10">
				<!-- Displaying alert if there is a success message -->
				<!-- For normal param use param.success, but since we are using a flash param so just use the name of the param -->
				<c:if test="${success != null}">
					<c:if test="${success == 'add'}">
						<div class="alert alert-success alert-dismissible show" role="alert">
							<strong>Customer Added SuccessFully</strong>
							<button type="button" class="close" data-dismiss="alert" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:if>
					<c:if test="${success == 'edit'}">
						<div class="alert alert-success alert-dismissible show" role="alert">
							<strong>Customer Updated SuccessFully</strong>
							<button type="button" class="close" data-dismiss="alert" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:if>
					<c:if test="${success == 'delete'}">
						<div class="alert alert-success alert-dismissible show" role="alert">
							<strong>Customer Deleted SuccessFully</strong>
							<button type="button" class="close" data-dismiss="alert" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:if>
				</c:if>
				<!-- Displaying alert if there is a error message -->
				<c:if test="${error != null}">
					<c:if test="${error == 'add'}">
						<div class="alert alert-danger alert-dismissible show" role="alert">
							<strong>Something went wrong at the moment of adding the customer</strong>
							<button type="button" class="close" data-dismiss="alert" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:if>
				</c:if>

				<table class="table table-responsive-xl table-bordered table-striped table-hover sortable">
					<thead class="thead">
						<tr>
							<th class="num" aria-sort="ascending">
								<button>
									Id
									<span aria-hidden="true"></span>
								</button>
							</th>
							<th>
								<button>
									First Name
									<span aria-hidden="true"></span>
								</button>

							</th>
							<th>
								<button>
									Last Name
									<span aria-hidden="true"></span>
								</button>
							</th>
							<th>
								<button>
									Email
									<span aria-hidden="true"></span>
								</button>
							</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<!-- Using JSTL -->
						<!-- Loop Over and Print Our Customers -->
						<c:forEach var="tempCustomer" items="${customers}">
							<tr>
								<td class="num">${tempCustomer.id}</td>
								<td>${tempCustomer.firstName}</td>
								<td>${tempCustomer.lastName}</td>
								<td>${tempCustomer.email}</td>
								<td>
									<!-- Creating the link for the update button -->
									<c:url var="updateLink" value="/customer/showFormForUpdate">
										<c:param name="customerId" value="${tempCustomer.id}" />
									</c:url>
									<!-- Creating the link for the delete button -->
									<c:url var="deleteLink" value="/customer/deleteCustomer">
										<c:param name="customerId" value="${tempCustomer.id}" />
									</c:url>
									<button type="button" class="btn btn-info">
										<a href="${updateLink}" class="linkButton">Update</a>
									</button>
									<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal${tempCustomer.id}">Delete</button>

									<!-- Modal to confirm the delete -->
									<div class="modal fade" id="deleteModal${tempCustomer.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h3 class="modal-title" id="exampleModalLabel${tempCustomer.id}">Confirm Delete</h3>
													<button type="button" class="close" data-dismiss="modal" aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">
													<h5>Are you sure that you want to delete the customer with the id ${tempCustomer.id} and name ${tempCustomer.firstName} ?</h5>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary" data-dismiss="modal">No,Close</button>
													<button type="button" class="btn btn-danger">
														<a href="${deleteLink}" class="linkButton"> Yes, Delete! </a>
													</button>
												</div>
											</div>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
	<!-- /container -->

</body>

</html>