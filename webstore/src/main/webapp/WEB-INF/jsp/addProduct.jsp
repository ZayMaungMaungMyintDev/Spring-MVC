<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Add Product</title>
</head>
<body>

	<section>
		<div class="jumbotron">
			<a href='<c:url value="/j_spring_security_logout"></c:url>'
				class="btn btn-danger btn-mini pull-right"> Logout </a>
			<div class="container">
				<h1>Products</h1>
				<p>Add Products</p>
			</div>
		</div>
	</section>

	<section class="container">
		<form:form modelAttribute="newProduct" cssClass="form-horizontal">
			<fieldset>

				<legend> Add New Product </legend>
				<div class="form-group">
					<label class="control-label col-lg-2" for="productId"> <spring:message
							code="addProduct.form.productId.label"></spring:message>
					</label>
					<div class="col-lg-10">
						<form:input id="productId" path="productId"
							cssClass="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="name"> Name </label>
					<div class="col-lg-10">
						<form:input id="name" path="name" cssClass="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="unitPrice"> Unit
						Price </label>
					<div class="col-lg-10">
						<form:input id="unitPrice" path="unitPrice"
							cssClass="form:input-large" />
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-lg-2" for="manufacturer">
						Manufacturer </label>
					<div class="col-lg-10">
						<form:input id="manufacturer" path="manufacturer"
							cssClass="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="category">
						Category </label>
					<div class="col-lg-10">
						<form:input id="category" path="category"
							cssClass="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="unitsInStock">
						Units In Stock </label>
					<div class="col-lg-10">
						<form:input id="unitsInStock" path="unitsInStock"
							cssClass="form:input-large" />
					</div>
				</div>

				<%-- <div class="form-group">
					<label class="control-label col-lg-2" for="unitsInOrder">
						Units In Order </label>
					<div class="col-lg-10">
						<form:input id="unitsInOrder" path="unitsInOrder"
							cssClass="form:input-large" />
					</div>
				</div> --%>

				<div class="form-group">
					<label class="control-label col-lg-2" for="description">
						Description </label>
					<div class="col-lg-10">
						<form:textarea id="description" path="description"
							cssClass="form:input-large" rows="2" />
					</div>
				</div>

				<%-- <div class="form-group">
					<label class="control-label col-lg-2" for="discontinued">
						Discontinued </label>
					<div class="col-lg-10">
						<form:checkbox id="discontinued" path="discontinued" />
					</div>
				</div> --%>

				<div class="form-group">
					<label class="control-label col-lg-2" for="condition">
						Condition </label>
					<div class="col-lg-10">
						<form:radiobutton path="condition" value="New" />
						New
						<form:radiobutton path="condition" value="Old" />
						Old
						<form:radiobutton path="condition" value="Refurbished" />
						Refurbished
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add">
					</div>
				</div>

			</fieldset>
		</form:form>
	</section>

</body>
</html>