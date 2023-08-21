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
<title>Pregunta</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container-fluid">
		<div class="col-9 mx-auto border-top border-bottom border-warning p-4 m-4">
			<div class="col-12 text-center my-4">
				<h2><c:out value="${question.question}"></c:out></h2>
			</div>
			<div class="d-flex align-items-center p-4">
				<p class="h4 m-0 mx-4 p-0">
					Tags:	
				</p>
				<c:forEach items="${tags}" var="tag">
					<p class="m-0 mx-2 p-2 border rounded border-dark">
						<c:out value="${tag.getSubject()}"></c:out>
					</p>
				</c:forEach>
			</div>
		</div>	
		
		<div class="col-9 mx-auto border-top border-bottom border-warning p-4 m-4 d-flex justify-content-between">
			<div class="col-5 border border-dark p-1 bg-dark">
				<table class="table table-dark table-hover full-width m-0">
					<tr>
						<th>Answers</th>
					</tr>
						<c:forEach items="${answer}" var="ans">
							<tr>
								<td class="bg-secondary">
									<c:out value="${ans.answer}"></c:out>														
								</td>
							</tr>
						</c:forEach>
				</table>
			</div>
			<div class="col-5 border border-dark ml-1">
				 <form:form action="/questions/${question.id}" method="post" modelAttribute="answerStr" class="full-width d-flex flex-column p-2">
				 	<form:label path="answer">Escribe una respuesta</form:label>
				 	<form:input path="questions" type="hidden" value="${question.id}"/>
				 	<form:input path="answer" type="text" class="form-control w-100"/>
				 	<button type="submit" value="Enviar respuesta" class="my-4 btn bg-success">Enviar Respuesta</button>
				 </form:form>
			</div>
		</div>	
		<div class="col-9 mx-auto d-flex justify-content-end border-top border-bottom border-warning pt-4 pb-4">
			<a href="/questions/new" class="btn btn-info col-2 mx-4">Nueva pregunta</a>				
			<a href="/questions" class="btn btn-warning col-2 mx-4">Volver</a>
		</div>
	</div>
</body>
</html>