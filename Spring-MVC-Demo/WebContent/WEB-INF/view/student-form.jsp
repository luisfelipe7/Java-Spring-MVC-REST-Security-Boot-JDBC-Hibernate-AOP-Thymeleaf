<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Student Form</title>
<h3>Welcome to the student form!</h3>
</head>

<body>
	<hr>
	<form:form action="processForm" modelAttribute="student">
	
	First Name: <form:input path="firstName" />

		<br>
		<br>
	
	Last Name: <form:input path="lastName" />

		<br>
		<br>
		
	Country: <form:select path="country">
			<!-- DYNAMIC VERSION -->
			<form:options items="${student.countryOptions}" />

			<!--  HARD CODED VERSION
			<form:option value="United States" label="United States" />
			<form:option value="Mexico" label="Mexico" />
			<form:option value="China" label="China" /> -->
		</form:select>

		<br>
		<br>
		
	Language:
	<form:select path="language">
			<!-- DYNAMIC VERSION -->
			<form:options items="${languagesOptions}" />
		</form:select>
		<br>
		<br>
		
	Favorite Programming Language:
	<br>
	
	Java <form:radiobutton path="favoritePLanguage" value="Java" />
	C++ <form:radiobutton path="favoritePLanguage" value="C++" />
	.Net <form:radiobutton path="favoritePLanguage" value=".Net" />
	Python <form:radiobutton path="favoritePLanguage" value="Python" />

		<br>
		<br>
	
	Operating Systems:
	
	Linux  <form:checkbox path="operatingSystems" value="Linux" />
	Windows  <form:checkbox path="operatingSystems" value="Windows" />
	Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />

		<br>
		<br>

		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>



