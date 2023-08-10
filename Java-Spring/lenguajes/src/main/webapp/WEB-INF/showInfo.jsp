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
	<div class="container">
		<div class="w-75 mx-auto">
			<div class="d-flex justify-content-between align-items-center my-5">	
				<h1>Lenguaje de programacion</h1>
				<a class="text-decoration-none btn btn-dark text-light" href="/languages">Dashboard</a>	
			</div>
			<ul class="list-group my-5">
				<li type="button" class="list-group-item list-group-item-action">
					<div class="text-info d-inline mr-2">Name:</div>
					<c:out value="${languages.name}"></c:out>
				</li>
				<li type="button" class="list-group-item list-group-item-action">
					<div class="text-info d-inline mr-2">Creator</div>
					<c:out value="${languages.creatorName}"></c:out>
				</li>
				<li type="button" class="list-group-item list-group-item-action">
					<div class="text-info d-inline mr-2">Version:</div>
					<c:out value="${languages.version}"></c:out>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>