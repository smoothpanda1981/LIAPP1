<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<h1>${message}</h1>
	<br/>
	<form method="POST" command="customerForm" action="/show/customer">
		<table>
			<tr>
				<td>New customer id:</td>
				<td><input path="customer_id" /></td>
			</tr>
			<tr>
				<td>Enter your email:</td>
				<td><input path="email" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>