<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
	<title>Contador</title>
</head>
<body>
	<div class="mx-auto w-75">
		<h1>Hola navegante, bienvenido de nuevo!</h1>
		<a class="btn bg-danger" href="/contador"> ir al contador </a>
		<a class="btn bg-warning" href="/"> Aumentar contador </a>
	</div>
</body>
</html>