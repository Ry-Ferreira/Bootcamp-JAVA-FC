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
	<form:form action="/persons/new" method="post" modelAttribute="persona" class="w-75 mx-auto d-flex flex-column">
    	<div class="d-flex flex-row justify-content-between form-group my-4">
        	<form:label path="firstName">First Name</form:label>
        	<form:errors class="text-danger" path="firstName"/>
        	<form:input path="firstName" class="form-control w-50"/>
    	</div>
    	<div class="d-flex flex-row justify-content-between form-group my-4">
        	<form:label path="lastName">Last Name</form:label>
        	<form:errors class="text-danger" path="lastName"/>
        	<form:input path="lastName" class="form-control w-50"/>
    	</div>
    	<input type="submit" value="Submit" class="my-4 btn bg-success"/>
	</form:form>    
</div>
</body>
</html>