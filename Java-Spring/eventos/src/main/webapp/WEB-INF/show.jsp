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
<title><c:out value="${event.name}"></c:out></title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container d-flex">
		<div class="col-6">
			<h1 class="my-4"><c:out value="${event.name}"></c:out></h1>
			<div class="col-6 border border-danger p-4">
				<p>Host: 
					<c:out value="${event.organizador.name}"></c:out>
				</p>
				<p>Fecha
					<fmt:formatDate value="${event.date}" pattern="MMMM dd, YYYY" var="eventDate"/>
					<c:out value="${eventDate}"></c:out>
				</p>
				<p>
					<c:out value="${event.location}"></c:out>,
					<c:out value="${event.state}"></c:out>
				</p>
				<p>Asistentes: 
					<c:out value="${event.asist.size()}"></c:out>
				</p>
				<div class="col-12 border border-dark p-2">
					<ul class="list-group list-group-flush">
					<c:forEach var="msg" items="${event.getMessages()}">
						<li class="list-group-item list-group-item-secondary">
							<c:out value="${usuario.name} dice: ${msg.comment}"></c:out>
						</li>
					</c:forEach>					
					</ul>
				</div>
			</div>
		</div>
		<div class="col-6 my-2 h-50">
			<h3 class="my-4">Message Wall</h3>
			<div class="col-12">
				<form action="/events/${event.id}/comentario" method="POST" class="form-group">
					<label> Add comments: </label>
					<textarea name="comment" class="form-control my-2"></textarea>
					<button class="btn btn-success my-2">Send Comment</button>
				</form>
			</div>
			<div class="col-12 d-flex my-4">
				<a href="/events" class="btn btn-dark">Back</a>
				<a href="/events" class="btn btn-info mx-4">Create event</a>
			</div>
		</div>
	</div>
</body>
</html>