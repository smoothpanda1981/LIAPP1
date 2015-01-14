<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<h1>${message}</h1>

	<table border="1px">
		<th>
			<td>
				CUSTOMER_ID
			</td>

		</th>
		<th>
			<td>
				EMAIL
			</td>

		</th>
	</table>
	<c:forEach items="${customerList}" var="customer">
		<c:out value="${customer.customer_id}"/>
		<c:out value="${customer.email}"/>
	</c:forEach>
</body>
</html>