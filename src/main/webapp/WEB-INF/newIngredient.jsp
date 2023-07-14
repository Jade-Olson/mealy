<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>Mealy | Create Ingredient</title>
</head>
<body>
<nav class="navbar navbar-expand-lg">
	<div class="container-fluid bg-secondary">
		<h1 class="navbar-brand">Mealy</h1>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="/home">Home</a>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="/meals">Meal List</a>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="/groceries">Grocery List</a>
				</li>
			</ul>
			<form id="logoutForm" method="POST" action="/logout">
	       		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	       		<input type="submit" value="Logout!" class="btn btn-primary m-2" />
	    	</form>
		</div>
	</div>
</nav>
<div class="container">
	<div class="row">
	<div class="col m-3">
			<div class="row border">
			<h3 class="display-6">Add Ingredient</h3>
			<form:form action="/ingredients/new" method="post" modelAttribute="ingredient">
				<div class="form-group">
					<form:label path="name" class="form-label">Name:</form:label>
					<form:input path="name" class="form-control"/>
					<form:errors path="name" class="text-danger"/>
				</div>
				<div class="form-group row">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<div class="col"></div>
						<input type="submit" value="Create" class="btn btn-primary m-3 col-sm-2"/>
					<div class="col"></div>
				</div>
			</form:form>
			</div>
			<div class="row"></div>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>