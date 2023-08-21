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
<title>Home</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container-fluid content">
		<div class="col-12 p-2 mb-4 text-center">
			<h1> Welcome to the Questions 
				<small class="text-info">
					Forum!
				</small>
			</h1>
			<h5 class="mt-4">
				Here is a table with all questions that already exist
			</h5>
		</div>
	
		<table class=" table table-dark table-hover">
				<thead>
					<tr>
						<th scope="col" class="bg-dark">Question</th>
						<th scope="col" class="bg-dark">Tags</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${quest}" var="qTag">
						<tr>
							<td class="bg-secondary">
								<a  href="/questions/${qTag.getId()}"
									class="text-decoration-none text-warning a-table-quest">
									<c:out value="${qTag.question}"></c:out>
								</a>
							</td>
								<td class="bg-secondary">
									<c:forEach items="${qTag.getTags()}" var="q">
										<c:out value="${q.getSubject()}"></c:out>
									</c:forEach>
								</td>													
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="col-12 d-flex ">
				<a href="/questions/new" class="btn btn-light border border-dark text-dark px-4 py-2">Nueva pregunta</a>
			</div>
	</div>
</body>
</html>