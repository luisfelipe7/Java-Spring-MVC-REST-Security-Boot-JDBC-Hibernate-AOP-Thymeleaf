<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Luv2Code Company Home Page</title>
</head>
<body>
	<h2>Luv2Code Company Home Page - Yoohoo - Silly Goose - NO SOUP!!!</h2>
	<hr>
	<p>Welcome to the Luv2Code Company Home Page!</p>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" />

	</form:form>

</body>
</html>