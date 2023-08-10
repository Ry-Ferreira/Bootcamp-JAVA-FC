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
<h1>Editar Libro</h1>
<div class="container">
	<div class="d-flex w-75 mx-auto flex-row-reverse">
		<a href="/languages/${languages.id}/delete" class="btn btn-danger text-decoration-none mx-2">Delete</a>
		<a href="/languages" class="btn btn-dark text-decoration-none mx-4">Dashboard</a>
	</div>


	<form:form action="/languages/edit/${languages.id}" method="post" modelAttribute="languages" class="w-75 mx-auto d-flex flex-column">
		<input type="hidden" name="_method" value="PUT"/>
    	<div class="d-flex flex-row justify-content-between form-group my-4">
        	<form:label path="name">Name</form:label>
        	<form:errors class="text-danger" path="name"/>
        	<form:input path="name" class="form-control w-50"/>
    	</div>
    	<div class="d-flex flex-row justify-content-between form-group my-4">
        	<form:label path="creatorName">Creator Name</form:label>
        	<form:errors class="text-danger" path="creatorName"/>
        	<form:input path="creatorName" class="form-control w-50"/>
    	</div>
   		<div class="d-flex flex-row justify-content-between form-group my-4">
        	<form:label path="version">Version</form:label>
        	<form:errors class="text-danger" path="version"/>
        	<form:input path="version" class="form-control w-50"/>
    	</div> 
    	<input type="submit" value="Submit" class="my-4 btn btn-success" />
	</form:form>    
</div>
</body>
</html>