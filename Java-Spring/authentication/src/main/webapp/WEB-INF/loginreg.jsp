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
		<div class="col-9 mx-auto d-flex flex-column justify-content-center text-center" >
			<h1>Register!</h1>
			<div class="col-12 text-center">
				<p class="text-danger mt-2">
					<form:errors path="user.*" />
				</p>					
			</div>					
			<form:form method="POST" action="/registration" modelAttribute="user" class="col-12 d-flex flex-column justify-content-center bg-dark p-4">
				<div class="d-flex justify-content-between p-3 form-group">
					<form:label path="email" class="text-white">Email:</form:label>
					<form:input type="email" path="email" class="w-50 p-1 form-control form-control-lg"/>
				</div>
				<div class="d-flex justify-content-between p-3 form-group">
					<form:label path="password" class="text-white">Password:</form:label>
					<form:password path="password" class="w-50 p-1 form-control form-control-lg"/>
				</div>
				<div class="d-flex justify-content-between p-3 form-group">
					<form:label path="passwordConfirmation" class="text-white">Password Confirmation:</form:label>
					<form:password path="passwordConfirmation" class="w-50 p-1 form-control form-control-lg"/>
				</div>
					<input type="submit" value="Register!" class="btn btn-primary"/>
				<p class="text-success mt-2 h3"><c:out value="${registro}"></c:out></p>
			</form:form>
		</div>
		<div class="col-9 mx-auto d-flex flex-column justify-content-center text-center mt-2" >		
			<h2>Login!</h2>
		
			<div class="col-12 text-center">
				<p class="text-danger mt-3">
					<form:errors path="login.*" />
				</p>					
			</div>	
		
			<form:form method="POST" action="/login" modelAttribute="login" class="col-12 d-flex flex-column justify-content-center bg-dark p-4">
				<div class="d-flex justify-content-between p-3 form-group">
					<form:label path="email" class="text-white">Email:</form:label>
					<form:input type="email" path="email" class="w-50 p-1 form-control form-control-lg"/>
				</div>
				<div class="d-flex justify-content-between p-3 form-group">
					<form:label path="password" class="text-white">Password:</form:label>
					<form:password path="password" class="w-50 p-1 form-control form-control-lg"/>
				</div>
					<input type="submit" value="Login!" class="btn btn-primary"/>
			</form:form>
		</div>
	</div>	



</body>
</html>



