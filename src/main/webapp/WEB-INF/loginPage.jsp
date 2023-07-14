<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>Mealy | Login</title>
</head>
<body>
<div class="container">
<div class="row p-4 mt-5 align-items-center rounded-3 border shadow-lg">
	<h1 class="display-4">Login to Mealy</h1>
    <form method="POST" action="/login">
        <div class="mt-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" id="username" name="username" class="form-control"/>
        </div>
        <div class="mt-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" id="password" name="password" class="form-control"/>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="mt-3">
	    <c:if test="${errorMessage != null}">
	        <p class="text-danger"><c:out value="${errorMessage}"></c:out></p>
	    </c:if>
	    </div>
	    <p>No Account? <a href="/register">Register</a> today!</p>
	    	<div>
	        <input type="submit" value="Login!" class="btn btn-primary mb-2"/>
	        <a class="btn btn-secondary mb-2" href="/">Go Back</a>
	        </div>
    </form>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
