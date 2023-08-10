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
	<h1> BIENVENIDO A LOS LENGUAJES DE PROGRAMACIÓN</h1>
	<table class="table table-dark table-hover w-75 mx-auto">
		<thead>
			<tr>
				<th class="bg-dark">Name</th>
				<th class="bg-dark">Creator</th>
				<th class="bg-dark">Version</th>
				<th class="bg-dark">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${languages}" var="lan">
				<tr>
					<td class="bg-secondary">
						<a href="/languages/${lan.id}" class="text-light ">
							<c:out value="${lan.name}"></c:out>						
						</a>
					</td>
					<td class="bg-secondary">
						<c:out value="${lan.creatorName}"></c:out>
					</td>
					<td class="bg-secondary">
						<c:out value="${lan.version}"></c:out>
					</td>
					<td class="bg-secondary w-25">
						<a class="text-decoration-none text-danger float-start" href="/languages/${lan.id}/delete">Delete</a>
						<a class="text-decoration-none text-warning float-end" href="/languages/edit/${lan.id}">Editar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

<!-- FORM DE CREACION -->
	<form:form 
		action="/languages" 
			method="post" 
				modelAttribute="language" 
					class="w-75 mx-auto d-flex flex-column mt-4">
					<div class="d-flex flex-row justify-content-between form-group my-4">	
						<form:label path="name" class="">Name</form:label>
						<form:errors path="name" class="text-danger border border-danger p-2" /> 
						<form:input class="input" type="text" path="name"/>
					</div>
					<div class="d-flex flex-row justify-content-between form-group my-4">
						<form:label path="creatorName">Creator</form:label>
						<form:errors path="creatorName" class="text-danger border border-danger p-2" /> 
						<form:input class="input" type="text" path="creatorName" />
					</div>
					<div class="d-flex flex-row justify-content-between form-group my-4">
						<form:label path="version">Version</form:label>
						<form:errors path="version" class="text-danger border border-danger p-2" /> 
						<form:input class="input" type="text" path="version" />
					</div>
					<div>
						<button class="btn btn-success" type="submit" value="Submit">Enviar</button>
					</div>
			
			
	</form:form>
</div>


</body>
</html>