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
<title>Productos</title>
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
					Producto:
				</small>
				<c:out value="${producto.name}"></c:out>
			</h1>
		</div>


		<!--  FORMULARIO  -->
		<form:form action="/aso/${producto.id}" method="post"
			modelAttribute="asociacion" class="col-12 d-flex flex-row p-4">
			<div
				class="d-flex flex-column justify-content-between form-group my-4 col-6">
				<div class="ml-0 mb-2">
					<h2>Categorias</h2>
				</div>
				<ul>
					<c:forEach items="${producto.getCategories()}" var="categoria">
						<li><c:out value="${categoria.name}"></c:out></li>
					</c:forEach>
				</ul>
			</div>
			<div
				class="d-flex flex-column justify-content-between form-group my-4 col-6">
				<form:input type="hidden" path="product" value="${producto.id}"
					class="form-control w-50" />
				<form:select class="form-control" path="category">
					<c:forEach items="${categorias}" var="c">
						<form:option value="${c.id}"> 
    					${c.name}
    				</form:option>
					</c:forEach>
				</form:select>
				<input type="submit" value="Agregar categoria"
					class="my-4 btn bg-info" />
			</div>
		</form:form>
	</div>
</body>
</html>