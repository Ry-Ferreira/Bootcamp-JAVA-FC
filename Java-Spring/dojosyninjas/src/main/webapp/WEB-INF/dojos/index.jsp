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
		<h1>Bienvenido a la DB de licencias de conducir</h1>
		<a class="btn btn-info my-4" href="/dojo/new">Agregar nuevo dojo</a>
		<a class="btn btn-info my-4"href="/ninja/new">Agrega nuevo ninja</a>
		
	
			<h1>Dojos</h1>
			<c:forEach items="${dojos}" var="dojo">
				<ul class="list-group">
  					<li class="
  						list-group-item hover 
  						list-group-item-primary list-group-item-action
  						">
  						<a href="/dojo/${dojo.id}">
  							<c:out 
  								value="${dojo.name}">
  							</c:out>
  						</a>
  					</li>
  				</ul>
  			</c:forEach>
			
			<h1>Ninjas</h1>
			<c:forEach items="${ninjas}" var="ninja">
				<ul class="list-group">
  					<li class="
  						list-group-item hover 
  						list-group-item-primary list-group-item-action
  						">
  						<c:out 
  							value="${ninja.firstName} ${ninja.lastName}">
  						</c:out>
  					</li>
  				</ul>
  			</c:forEach>
	</div>
</body>
</html>