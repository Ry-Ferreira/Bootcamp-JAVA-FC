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
<title>STUDENTS DASHBOARD</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container-fluid">
		<div class="col-12 my-4 p-4 border-bottom border-4 border-dark text-center">
			<h1 class="text-muted">ALL STUDENTS HERE!</h1>
		</div>
		
		<div class="col-9 my-5 mx-auto">
			<table class=" table table-dark table-hover">
				<thead>
					<tr>
						<th scope="col" class="bg-dark">Nombre</th>
						<th scope="col" class="bg-dark">Age</th>
						<th scope="col" class="bg-dark">Address</th>
						<th scope="col" class="bg-dark">City</th>
						<th scope="col" class="bg-dark">State</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${students}" var="s">
						<tr>
							<td class="bg-secondary"><c:out value="${s.firstName} ${s.lastName}"></c:out></td>
							<td class="bg-secondary"><c:out value="${s.age}"></c:out></td>
							<td class="bg-secondary"><c:out value="${s.getAddress().getAddress()}"></c:out></td>
							<td class="bg-secondary"><c:out value="${s.getAddress().getCity()}"></c:out></td>
							<td class="bg-secondary"><c:out value="${s.getAddress().getState()}"></c:out></td>						
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-9 mx-auto d-flex flex-row justify-content-center my-5">
			<div class="mx-4 w-25">
				<a href="/students/new" class="btn btn-success p-4 w-100"> Ingresar </a>
			</div>
			<div class="mx-4 w-25">
				<a href="/contact/new" class="btn btn-info p-4 w-100"> Agregar contacto</a>
			</div>
		</div>
	</div>
</body>
</html>