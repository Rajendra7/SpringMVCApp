<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Withdraw Form</h1>
	<form action="withdrawAmount">
		<label>Account Number : <input type="number" name="accountNumber" required="required"></label><br>
		<br> <label>Amount : <input type="number" name="amount" required="required"></label><br>
		<br> <label><input type="submit" name="submit"
			value="Submit"></label>
	</form>
</body>
</html>