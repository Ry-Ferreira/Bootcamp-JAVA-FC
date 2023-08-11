<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formateo fechas (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Formulario form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- para errores de renderizado en rutas PUT -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AQUI EL TITULO DE TU PLNATILLA</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container-fluid d-flex flex-column align-items-center justify-content-center vh-100">
		<div class="col-12 text-center">
			<h2 class="font-italic m-4"> Contact Info </h2>
		</div>
		<div class="col-9 mx-auto">
			<form method="POST" action="/contact/new" class="w-50 p-4 wy-4 mx-auto d-flex flex-column justify-content-center align-items-center border rounded border-dark">
				<div class="row col-9 my-1">
					<label for="select"> Student: </label>
					<select class="form-control w-100" name="student">
    					<c:forEach items="${students}" var="s">
    						<option value="${s.id}">
    							${s.firstName} ${s.lastName}
    						</option> 
    					</c:forEach>
    				</select>
				</div>
				<div class="row col-9 my-1">
					<label for="address">Address</label>
					<input type="text" id="address" name="address" class="form-control border-warning"/>
				</div>
				<div class="row col-9 my-1">
					<label for="city">City: </label>
					<input type="text" id="city" name="city" class="form-control border-warning"/>
				</div>
				<div class="row col-9 my-1">
					<label for="state">State: </label>
					<input type="text" id="state" name="state" class="form-control border-warning"/>
				</div>
				<div class="row col-9 my-4">
					<button type="submit" class="btn btn-success p-2 ">Create</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>