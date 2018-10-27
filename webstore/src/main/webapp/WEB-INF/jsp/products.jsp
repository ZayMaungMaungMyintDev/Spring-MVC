<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
			<h1> All the available products in our store </h1>
		</div>
	</div>
</section>

<section class="container">
	<div class="row">
		<c:forEach items="${products}" var="product">
		<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
			<div class="thumbnail">
				<img alt="image" src='<c:url value="/resources/images/${product.productId}.png"></c:url>' style="width:100%">
				<div class="caption">
					<h3> ${product.name} </h3>
					<p> ${product.description} </p>
					<p> ${product.unitPrice} </p>
					<p> Available ${product.unitsInStock} unit in stock </p>
					<p>
						<a href="<spring:url value="/products/product?id=${product.productId}" />"
						class="btn btn-primary"> 
							<span class="glyphicon-info-sign glyphicon"></span> Detail
						</a>
					</p>	
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
</section>

</body>
</html>