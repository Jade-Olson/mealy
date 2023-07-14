<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>Mealy | Register</title>
</head>
<body>
<div class="container">
<div class="row p-4 mt-5 align-items-center rounded-3 border shadow-lg">
    <h1 class="display-4">Register with Mealy today!</h1>
    <form:form method="POST" action="/register" modelAttribute="user"> <!-- JSTL form already use CSRF tokens, hidden input not required -->
        <div class="mt-2">
            <form:label path="username" class="form-label">Username:</form:label>
            <form:input path="username" class="form-control"/>
            <form:errors path="username" class="text-danger"/>
        </div>
        <div class="mt-2">
            <form:label path="email" class="form-label">Email:</form:label>
            <form:input path="email" class="form-control"/>
           	<form:errors path="email" class="text-danger"/>
        </div>
        <div class="mt-2">
            <form:label path="password" class="form-label">Password:</form:label>
            <form:password path="password" class="form-control"/>
            <form:errors path="password" class="text-danger"/>
            <form:errors path="passwordConfirmation" class="text-danger"/>
        </div>
        <div class="mt-2">
            <form:label path="passwordConfirmation" class="form-label">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation" class="form-control"/>
            <form:errors path="passwordConfirmation" class="text-danger"/>
        </div>
        <p class="mt-2">Already have an account? <a href="/login">Login</a></p>
        <div>
	        <input type="submit" value="Register!" class="btn btn-primary mb-2"/>
	        <a class="btn btn-secondary mb-2" href="/">Go Back</a>
	        </div>
    </form:form>
</div>
</div>
    
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
