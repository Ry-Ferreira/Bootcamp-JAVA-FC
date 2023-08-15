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
	<div class="container-fluid">
		<div class="container-fluid text-center my-4 py-4 nav-top text-white">
			<h1>
				<small class="text-muted mx-4">
					Categoria:
				</small>
				<c:out value="${categoria.name}"></c:out>
			</h1>
		</div>
		<div class="row">
			<div class="col-6">
				<h2>Productos con esta categoria</h2>
				<ul>
					<c:forEach items="${categoria.getProducts()}" var="producto">
						<li> <c:out value="${producto.name }"></c:out>  </li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-6 border-left">
				<h2>Añadir producto:</h2>
				<form:form 
					action="/asoCat/${categoria.id }" 
					method="post"
					modelAttribute="asociacionCat">
					<form:input type="hidden" path="category" value="${categoria.id }" />
					<form:select class="form-control" path="product">
						<c:forEach items="${producto}" var="producto">
							<form:option value="${producto.id}"> 
								${producto.name}  
							</form:option>
						</c:forEach>
					</form:select>
					<input type="submit" value="Agregar producto"
					class="my-4 btn bg-info" />
				</form:form>
			</div>
		</div>
	</div>
	
	
</body>
</html>