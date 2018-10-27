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
<title>Login Page</title>
</head>
<body>

	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Kwee Zay Online Shop</h1>
				<p>Add Products</p>
			</div>
		</div>
	</section>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-defaut">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">
								<spring:message
									code="AbstractUserDetailsAuthenticationProvider.badCredentials"></spring:message>
							</div>
						</c:if>
						<form action='<c:url value="/j_spring_security_check"></c:url>' method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="User Name" name="j_username" type="text" />
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password" name="j_password" type="password" value="" />
								</div>
								<input class="btn btn-lg btn-success btn-block" type="submit" value="Login" />
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>