<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE HTML>
<html>
<head>
<title>Luv2Code Company Home Page</title>
</head>
<body>
	<h2>Luv2Code Company Home Page - Yoohoo - Silly Goose - NO SOUP!!!</h2>
	<hr>
	<p>Welcome to the Luv2Code Company Home Page!</p>
	<hr>
	<!-- Displaying user name and role  -->
	<p>
		User:
		<security:authentication property="principal.username" />
		<br>
		Role (s):
		<security:authentication property="principal.authorities" />
	</p>

	<security:authorize access="hasRole('MANAGER')">
		<!-- Add a link to point /leaders ... this is for the managers -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(Only for Manager People)
		</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">

		<!-- Add a link to point /systems ... this is for the admins -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
			(Only for Admin People)
		</p>
	</security:authorize>


	<hr>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />

	</form:form>
</body>
</html>