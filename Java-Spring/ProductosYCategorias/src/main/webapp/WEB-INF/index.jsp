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
<!--   BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	
	<div class="container-fluid">
		<div class="container-fluid text-center mt-4">
			<h1> Bienvenido a Productos y Categorias</h1>	
		</div>
		<div class="container-fluid d-flex align-items-center justify-content-center mt-4 p-3 nav-top">
			<div class="mx-2 text-white">
				<p class="m-0 p-2 border rounded border-light">Añadir:</p>
			</div>
			<a class="text-decoration-none p-2 mx-2 bg-dark text-white border rounded" href="/products/new">Productos</a>
			<a class="text-decoration-none p-2 mx-2 bg-dark text-white border rounded" href="/category/new">Categorias</a>		
		</div>		
		
		<div class="container-fluid d-flex mt-4 p-0">
			<table class="table table-dark table-hover mt-4 w-100">
				<thead>
					<tr>
						<th scope="col" class="bg-dark">Product</th>
						<th scope="col" class="bg-dark">Description</th>
						<th scope="col" class="bg-dark">Price</th>
						<th scope="col" class="bg-dark">Category</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${producto}" var="producto">
						<tr>
							<td class="bg-secondary"><c:out value="${producto.name}"></c:out></td>
							<td class="bg-secondary"><c:out value="${producto.description}"></c:out></td>
							<td class="bg-secondary"><c:out value="${producto.price}"></c:out></td>
							<!--  ARREGLAR PARA QUE MUESTRE EL NUMERO DE LAS CATEGORIAS -->
							<td class="bg-secondary"><c:out value="${producto.getCategories()}"></c:out></td>			
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>