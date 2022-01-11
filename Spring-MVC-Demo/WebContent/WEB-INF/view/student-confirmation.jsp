<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<title>Student Confirmation</title>
<h3>Student Confirmed!</h3>
</head>

<body>
	<hr>
	The student is confirmed: ${student.firstName} - ${student.lastName }
	<br>
	<br>
	Country: ${student.country}
	<br>
	<br>
	Language: ${student.language}
	<br>
	<br>
	Favorite Programming Language: ${student.favoritePLanguage}
	<br>
	<br>
	Operating Systems:
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems}">
			<li>${temp}</li>
		</c:forEach>
	</ul>
</body>
</html>



