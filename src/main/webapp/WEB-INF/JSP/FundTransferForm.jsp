<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Transfer Funds!!</h1>
	<form action="transferFunds">
		<label>Sender's Account Account : <input type="number" name="sender" required="required"></label><br>
		<br> <label>Reciever's Account Account : <input type="number" name="receiver" required="required"></label><br>
		<br> <label>Amount : <input type="number" name="amount" required="required"></label><br>
		<br> <label><input type="submit" name="submit"
			value="Submit"></label> <label><input type="reset"
			name="reset" value="Reset"></label>
	</form>
</body>
</html>