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
<title>Nuevo Producto</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container">
		<div class="p-4 my-4 col-12 d-flex justify-content-center border rounded border-primary">
			<h1 class="font-italic ">
				Agregar
				<small class="text-muted">Producto</small> 
			</h1>
		</div>
		
		<div>
			<form method="POST" modelAttribute="producto" action="/products/new" class="w-50 p-4 wy-4 mx-auto d-flex flex-column justify-content-center align-items-center border rounded border-dark">
				<div class="row col-9 my-1">
					<label for="name">Nombre:</label>
					<input type="text" id="name" name="name" class="form-control border-warning"/>
				</div>
				<div class="row col-9 my-1">
					<label for="lastName">Descripcion:</label>
					<input type="text" id="lastName" name="description" class="form-control border-warning"/>
				</div>
				<div class="row col-9 my-1">
					<label for="age">Precio:</label>
					<input type="number" id="age" name="price" class="form-control border-warning"/>
				</div>
				<div class="row col-9 my-4">
					<button type="submit" class="btn btn-success p-2 ">Agregar</button>
					<div class="d-flex justify-content-around align-items-center mt-2">
						<a href="/" class="text-decoration-none border rounded border-dark p-2 col-3 text-center">Volver</a>
						<p class="m-0">|</p>
						<a href="/category/new" class="text-decoration-none border rounded border-dark p-2 col-3">Categoria</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>