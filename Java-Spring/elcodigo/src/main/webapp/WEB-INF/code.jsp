<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	
	<ul>
		<c:forEach items="${arreglo}" var="elemento">
			<li><c:out value="${elemento}"></c:out></li>
		</c:forEach>
	</ul>
	
	<button class="btn bg-warning">
		<a class="text-decoration-none" href="/">Vovler</a>
	</button>
</body>
</html>