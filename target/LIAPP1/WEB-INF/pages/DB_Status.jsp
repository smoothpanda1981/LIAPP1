<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<h1>${message}</h1>
	<br/>
	<a href="/">back</a>
	<br/>
	<table border="1px">
		<tr>
			<td align="center">
				CUSTOMER_ID
			</td>
			<td align="center">
				EMAIL
			</td>

		</tr>
		<c:forEach items="${customerList}" var="customer">
			<tr>
				<td align="center"><c:out value="${customer.customer_id}"/></td>
				<td align="center"><c:out value="${customer.email}"/></td>
			</tr>
		</c:forEach>
	</table>
	<br/><br/>

	<table border="1px">
		<tr>
			<td align="center">
				VOUCHER_ID
			</td>
			<td align="center">
				VOUCHER_TEXT
			</td>
			<td align="center">
				COMPANY_NAME
			</td>
			<td align="center">
				FLAG
			</td>
		</tr>
		<c:forEach items="${voucherList}" var="voucher">
			<tr>
				<td align="center"><c:out value="${voucher.voucher_id}"/></td>
				<td align="center"><c:out value="${voucher.voucher_text}"/></td>
				<td align="center"><c:out value="${voucher.company_name}"/></td>
				<td align="center"><c:out value="${voucher.flag}"/></td>
			</tr>
		</c:forEach>
	</table>
	<br/><br/>

	<table border="1px">
		<tr>
			<td align="center">
				ID
			</td>
			<td align="center">
				CUSTOMER_ID
			</td>
			<td align="center">
				VOUCHER_ID
			</td>
		</tr>
		<c:forEach items="${customerVoucherList}" var="customerVoucher">
			<tr>
				<td align="center"><c:out value="${customerVoucher.id}"/></td>
				<td align="center"><c:out value="${customerVoucher.customer_id}"/></td>
				<td align="center"><c:out value="${customerVoucher.voucher_id}"/></td>
			</tr>
		</c:forEach>
	</table>
	<br/><br/>
</body>
</html>