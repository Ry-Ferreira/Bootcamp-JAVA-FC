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
<title>Events</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container mx-auto">
		<div class="container mx-auto text-center my-4">
			<h1 class="text-muted">
				<c:out value="${event.name}"></c:out>
			</h1>
		</div>

		<form:form method="POST" action="/events/${editEvent.id}/edit"
			modelAttribute="editEvent"
			class="d-flex flex-column justify-content-evenly bg-info p-3">
			<p class="h3 text-dark">Edit Event</p>
			<input type="hidden" name="_method" value="put" />
			<form:input type="hidden" path="organizador" value="${usuario.id}"></form:input>
			<div class="d-flex justify-content-between form-group my-2">
				<form:label path="name" class="text-dark">Nuevo nombre:</form:label>
				<form:errors class="text-danger" path="name" />
				<form:input type="text" path="name"
					class="w-50 p-1 form-control form-control-sm" />
			</div>
			<div class="d-flex justify-content-between form-group my-2">
				<form:label path="date" class="text-dark">Fecha del evento</form:label>
				<form:errors class="text-danger" path="date" />
				<form:input type="date" path="date"
					class="w-50 p-1 form-control form-control-sm" />
			</div>
			<div class="d-flex justify-content-between my-2">
				<form:errors class="text-danger" path="location" />
				<form:errors class="text-danger" path="state" />
			</div>
			<div class="d-flex justify-content-between form-group my-2">
				<form:label path="state" class="text-dark">Ubicacion:</form:label>
				<div class="d-flex w-50">
					<form:input type="text" path="location" 
						class="w-75 form-control form-control-sm" />
					<form:select path="state" type="text"
						class="w-25 form-control">
						<c:forEach items="${states}" var="st">
							<option>${st}</option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<input type="submit" value="Edit Event!" class="btn btn-dark" />
		</form:form>
	</div>
</body>
</html>