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
<title>Questions Dashboard</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="container-fluid col-9 mx-auto">
		<div class="col-12 mx-auto text-center p-4">
			<h3 class="p-4">Hola de nuevo!, Aquí podrás crear una nueva pregunta</h3>
		</div>
		<form:form action="/questions/new" method="post" modelAttribute="questionTag" class="w-75 mx-auto d-flex flex-column">
			<!-- INPUT PARA PREGUNTA -->
    		<div class="d-flex flex-row justify-content-between form-group my-4">
        		<form:label path="question.question">Question </form:label>
        		<form:errors class="text-danger" path="question.question"/>
        		<form:input type="text" path="question.question" class="form-control w-50"/>
    		</div>   
    		
    		<!-- INPUT PARA TAGS -->
			<div class="d-flex flex-row justify-content-between form-group my-4">
        		<form:label path="tag.subject">Tags</form:label>
        		<form:errors class="text-danger" path="tag.subject"/>
        		<p class="text-danger"><c:out value="${error}"></c:out></p>
        		<form:input type="text" path="tag.subject" class="form-control w-50"/>
    		</div>	
	    	<input type="submit" value="Crear pregunta" class="my-4 btn bg-info"/>    
		</form:form>
	</div>
</body>
</html>