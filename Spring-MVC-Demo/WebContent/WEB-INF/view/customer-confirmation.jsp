<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Customer Confirmation</title>
<h1> Customer Confirmed!</h1>
</head>
<body>
<hr>
<b>Customer data:</b>
The customer confirmed is ${customer.firstName} ${customer.lastName}
<br>
Free passes: ${customer.freePasses}
<br>
Postal Code: ${customer.postalCode}
<br>
Course Code: ${customer.courseCode}
</body>
</html>