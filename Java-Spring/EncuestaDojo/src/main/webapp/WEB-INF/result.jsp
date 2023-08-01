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
<title>Resultado</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container vh-100 d-flex align-items-center">
		<div class="w-75 mx-auto p-4 full-height border border-secondary">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">SUBMITTED INFO</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">Name</th>
						<td><c:out value="${name}"></c:out></td>
						
					</tr>
					<tr>
						<th scope="row">Dojo Location</th>
						<td><c:out value="${location}"></c:out></td>
						
					</tr>
					<tr>
						<th scope="row">Favorite Language</th>
						<td colspan="2"><c:out value="${language}"></c:out></td>
					</tr>
					<tr>
						<th scope="row">Comment</th>
						<td colspan="2"><c:out value="${comment}"></c:out></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>