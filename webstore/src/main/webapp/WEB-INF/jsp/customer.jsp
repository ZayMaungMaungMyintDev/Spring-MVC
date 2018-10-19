<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>

<section>
	<div class="jumbotron">
		<div class="container">
			<h1> Customer Information </h1>
		</div>
	</div>
</section>

<section class="container">
	<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th> CUSTOMER ID </th>
						<th> NAME </th>
						<th> ADDRESS </th>
						<th> NUMBER OF ORDER MADE </th>
					</tr>
				</thead>
				<c:forEach items="${customers}" var="customer">
					<tbody>
						<tr>
							<td> ${customer.customerId} </td>
							<td> ${customer.name} </td>
							<td> ${customer.address} </td>
							<td> ${customer.noOfOrdersMade} </td>
						</tr>
				</tbody>
				</c:forEach>
			</table> 
	</div>
</section>

</body>
</html>