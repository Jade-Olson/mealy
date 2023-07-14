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
<title>Mealy</title>
</head>
<body>
<div class="px-4 py-5 my-5 text-center">
	<img class="d-block mx-auto mb-2" width="100" src="<c:url value="/img/logo.png"/>">
	<h1 class="display-5 fw-bold text-body-emphasis">Welcome to Mealy</h1>
	<div class="col-lg-6 mx-auto">
		<p class="lead mb-4">Your one-stop-shop for recipe storage and meal planning. With Mealy you can create recipes, plan out up to twelve days of meals, and have a grocery list created for you to make shopping for ingredients a breeze!</p>
		<div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
			<a href="/login" class="btn btn-primary btn-lg px-4 gap-3">Login</a>
			<a href="/register" class="btn btn-outline-secondary btn-lg px-4">Register</a>
		</div>
	</div>
</div>

<div class="container my-5">
    <div class="row p-4 pb-0 pe-lg-0 pt-lg-5 align-items-center rounded-3 border shadow-lg">
      <div class="col-lg-7 p-3 p-lg-5 pt-lg-3">
        <h1 class="display-4 fw-bold lh-1 text-body-emphasis">All your recipes in one place</h1>
        <p class="lead">Quickly and easily write out recipes and have them all on-hand when you need them the most. No more looking through cabinets or cook books in search of a recipe, once you write it in Mealy, you'll have peace of mind knowing every recipe you need is ready and waiting for you.</p>
      </div>
      <div class="col-lg-4 offset-lg-1 p-0 overflow-hidden shadow-lg">
          <img class="rounded-lg-3" src="<c:url value="/img/Screenshot1.png"/>" alt="" width="720">
      </div>
    </div>
  </div>

<div class="px-4 pt-5 my-5 text-center border-bottom">
    <h1 class="display-4 fw-bold text-body-emphasis">Meal Planning Made Easy</h1>
    <div class="col-lg-6 mx-auto">
      <p class="lead mb-4">In mere minutes create an entire meal plan for the next 12 days from recipes you already have! No more forgetting to buy an ingredient, have Mealy generate a grocery list for you as well so you always know exactly what you'll need to buy to complete your planned meal.</p>
    </div>
    <div class="overflow-hidden" style="max-height: 35vh;">
      <div class="container px-5">
        <img src="<c:url value="/img/Screenshot2.png"/>" class="img-fluid border rounded-3 shadow-lg mb-4" alt="Example image" width="700" height="500" loading="lazy">
      </div>
    </div>
  </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>