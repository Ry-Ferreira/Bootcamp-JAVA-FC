<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container vh-100 d-flex align-items-center">
		<form class="w-75 mx-auto p-4 full-height border border-secondary" method="POST" action="/verificar">
			
			<p class="text-danger"> <c:out value="${errorName}"></c:out></p>
			<div class="d-flex flex-row justify-content-between my-3">
				<label for="name"> Your Name:</label>
				<input type="text" id="name" name="name" class="w-50 form-control">
			</div>
			
			<p class="text-danger"> <c:out value="${errorLocation}"></c:out></p>
			<div class="d-flex flex-row justify-content-between my-3">
				<label for="location"> Dojo Location: </label>
				<select id="location" name="location" class="w-50 form-control">
					<option></option>
					<option>San Jose</option>
					<option>Montevideo</option>
					<option>Canelones</option>
				</select>
			</div>
			
			<p class="text-danger"> <c:out value="${errorLanguage}"></c:out></p>
			<div class="d-flex flex-row justify-content-between my-3">
				<label for="language"> Favorite Language </label>
				<select id="language" name="language" class="w-50 form-control">
					<option></option>
					<option>Python</option>
					<option>C++</option>
					<option>Java</option>
				</select>
			</div>
			
			<div class="row my-3">
				<label for="comment">Comment (optional):</label>
				<textarea id="comment" name="comment" rows="3" class="form-control mt-2"></textarea>
			</div>
			<div class="d-flex justify-content-end my-3">		
				<button type="submit" class="btn px-4 py-2" style="background-color:#327E9A;">Send</button>
			</div>
		</form>	
	</div>
</body>
</html>