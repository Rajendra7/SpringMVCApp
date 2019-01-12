<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action ="createAccount">
	           	<center><h1>CREATE A NEW SAVINGS ACCOUNT</h1> 
	           	<label>Name :<br><input type="text" name="accountHolderName" pattern =[A-Za-z]{1,25} title="only alphabets and maximum 25 characters" placeholder="Enter Name"/></label><br><br>
				<label>AccountBalance :<br><input type="text" name="accountBalance"></label><br><br>
				<label>Salaried :</label>
				<label><input type="radio" name="salary" value="yes">YES</label>
				<label><input type="radio" name="salary" value="no">NO</label><br><br>
				<label><input type="submit" name="submit" value="Submit"></label>
				<label><input type="reset" name="reset" value="Reset"></label>
   
        </form>
</body>
</html>