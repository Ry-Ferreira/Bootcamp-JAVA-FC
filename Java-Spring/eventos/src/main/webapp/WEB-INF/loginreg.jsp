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
<title>Login</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>

	<div class="container d-flex">
		<div class="col-5 mx-auto d-flex-column justify-content-center text-center" >
			<h1>Register!</h1>
			<div class="col-12 text-center">
				<p class="text-danger mt-2">
					<form:errors path="user.*" />
				</p>					
			</div>					
			<form:form method="POST" action="/registration" modelAttribute="user" class="d-flex flex-column justify-content-evenly bg-dark p-4 h-100">
				<div class="d-flex justify-content-between form-group">
					<form:label path="name" class="text-white">Nombre:</form:label>
					<form:input type="text" path="name" class="w-50 p-1 form-control form-control-sm"/>
				</div>
				<div class="d-flex justify-content-between form-group">
					<form:label path="lastName" class="text-white">Appelido:</form:label>
					<form:input type="text" path="lastName" class="w-50 p-1 form-control form-control-sm"/>
				</div>
				<div class="d-flex justify-content-between form-group">
					<form:label path="email" class="text-white">Email:</form:label>
					<form:input type="email" path="email" class="w-50 p-1 form-control form-control-sm"/>
				</div>
				<div class="d-flex justify-content-between form-group">
					<form:label path="location" class="text-white">Ubicacion:</form:label>
					<div class="d-flex w-50">
						<form:input type="text" path="location" class="w-75 form-control form-control-sm"/>
						<form:select path="state" type="text" class="w-25 form-control">
							<c:forEach items="${states}" var="st">					
								<option>${st}</option>						
							</c:forEach>
						</form:select>
					</div>
				</div>				
				<div class="d-flex justify-content-between form-group">
					<form:label path="password" class="text-white">Password:</form:label>
					<form:password path="password" class="w-50 p-1 form-control form-control-sm"/>
				</div>
				<div class="d-flex justify-content-between form-group">
					<form:label path="passwordConfirmation" class="text-white">Password Confirmation:</form:label>
					<form:password path="passwordConfirmation" class="w-50 p-1 form-control form-control-sm"/>
				</div>
					<input type="submit" value="Register!" class="btn btn-primary"/>
				<p class="text-success mt-2 h3"><c:out value="${registro}"></c:out></p>
			</form:form>
		</div>
		<div class="col-5 mx-auto d-flex-column justify-content-center text-center" >		
			<h1>Login!</h1>
		
			<div class="col-12 text-center">
				<p class="text-danger mt-3">
					<form:errors path="login.*" />
				</p>					
			</div>	
		
			<form:form method="POST" action="/login" modelAttribute="login" class="d-flex flex-column justify-content-evenly bg-dark p-4 h-100">
				<div class="d-flex justify-content-between form-group">
					<form:label path="email" class="text-white">Email:</form:label>
					<form:input type="email" path="email" class="w-50 p-1 form-control form-control-sm"/>
				</div>
				<div class="d-flex justify-content-between form-group">
					<form:label path="password" class="text-white">Password:</form:label>
					<form:password path="password" class="w-50 p-1 form-control form-control-sm"/>
				</div>
					<input type="submit" value="Login!" class="btn btn-primary"/>
			</form:form>
		</div>
	</div>	



</body>
</html>



