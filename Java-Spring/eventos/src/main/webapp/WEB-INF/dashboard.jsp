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
<title>APP</title>
<!-- BOOTSTRAP  -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- cambiar para que coincida con Tu archivo/estructura de nombres -->
<link rel="stylesheet" href="/css/main.css">
<script type="text/javascript" src="/js/app.js"></script>

</head>	
<body>
	<div class="container-fluid text-center">
	
		<div>
			<h1>Bienvenido 
				<c:out value="${usuario.name}"></c:out>
			</h1>
			<div class="text-end">
				<a href="/logout">Cerrar sesion</a>		
			</div>		
		</div>
		
		<div>
			<p class="h4">Aqui hay algunos eventos en tu zona</p>
			<table class="table table-hover table-dark">
				<thead>
					<tr>
						<th>Tittle Event</th>
						<th>Date</th>
						<th>Location</th>
						<th>State</th>
						<th>Host</th>
						<th>Action/Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${sameEventState}" var="eventsUser">
							<tr>
								<td>
									<a href="/events/${eventsUser.id}">
										<c:out value="${eventsUser.name}"></c:out>
									</a>
								</td>
								<td> 
									<fmt:formatDate value="${eventsUser.date}" pattern="MMMM dd, YYYY" var="eventDate"/>
									<c:out value="${eventDate}"></c:out>
								</td>
								<td><c:out value="${eventsUser.location}"></c:out></td>
								<td><c:out value="${eventsUser.state}"></c:out></td>
								<td><c:out value="${eventsUser.organizador.getName()}"></c:out></td>
								<td>
									<c:choose>
										<c:when test="${eventsUser.organizador.id == usuario.id}">
											<div class="d-flex justify-content-around">
												<a href="/events/${eventsUser.id}/edit" class="text-decoration-none btn btn-info">Edit</a>
													<div class="vl"></div>
												<form:form action="/events/${eventsUser.id}" method="POST">
													<input type="hidden" name="_method" value="delete" />
													<input type="submit" value="Delete" class="btn btn-danger"/>
												</form:form>			
											</div>
											<%-- 
											<form:form action="/event/delete" method="post">
												<form:input path="delete" type="hidden" />
												<button class="btn btn-danger">Delete</button>
											</form:form>
											--%>
										</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${eventsUser.asist.contains(usuario)}">
												<a href="/events/${eventsUser.id}/${usuario.id}/cancelar">Cancel</a>
											</c:when>
											<c:otherwise>
												<a href="/events/${eventsUser.id}/${usuario.id}/unirse">Join</a>
											</c:otherwise>
										</c:choose>
									</c:otherwise>
								</c:choose>	
								</td>
							</tr>					
					</c:forEach>
				</tbody>
			</table>		
		</div>
		
		<div>
			<p class="h4">Aqui hay algunos eventos fuera de tu zona</p>
			<table class="table table-hover table-secondary">
				<thead>
					<tr>
						<th>Tittle Event</th>
						<th>Date</th>
						<th>Location</th>
						<th>State</th>
						<th>Host</th>
						<th>Action/Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${otherEvent}" var="otherEvents">
							<tr>
								<td>
									<a href="/events/${otherEvents.id}">
										<c:out value="${otherEvents.name}"></c:out>
									</a>
								</td>
								<td> 
									<fmt:formatDate value="${otherEvents.date}" pattern="MMMM dd, YYYY" var="eventDate"/>
									<c:out value="${eventDate}"></c:out>
								</td>
								<td><c:out value="${otherEvents.location}"></c:out></td>
								<td><c:out value="${otherEvents.state}"></c:out></td>
								<td><c:out value="${otherEvents.organizador.getName()}"></c:out></td>
								<td>
									<c:choose>
										<c:when test="${otherEvents.organizador.id == usuario.id}">
											<div class="d-flex justify-content-around">
												<a href="/events/${otherEvents.id}/edit" class="text-decoration-none btn btn-info">Edit</a>
													<div class="vl"></div>
													<form:form action="/events/${otherEvents.id}" method="POST">
														<input type="hidden" name="_method" value="delete" />
														<input type="submit" value="Delete" class="btn btn-danger"/>
													</form:form>							
											</div>
											<%-- 
											<form:form action="/event/delete" method="post">
												<form:input path="delete" type="hidden" />
												<button class="btn btn-danger">Delete</button>
											</form:form>
											--%>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${otherEvents.asist.contains(usuario)}">
													<a href="/events/${otherEvents.id}/${usuario.id}/cancelar">Cancel</a>
												</c:when>
												<c:otherwise>
													<a href="/events/${otherEvents.id}/${usuario.id}/unirse">Join</a>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose>	
								</td>
							</tr>					
					</c:forEach>
				</tbody>
			</table>		
		</div>
		
		<div class="col-6 mx-auto">
			<form:form method="POST" action="/new/event" modelAttribute="event" class="d-flex flex-column justify-content-evenly bg-info p-3">
				<form:input type="hidden" path="organizador" value="${usuario.id}"></form:input>
				<div class="d-flex justify-content-between form-group my-2">
					<form:errors class="text-warning" path="name" />	
					<form:label path="name" class="text-dark">Nombre:</form:label>
					<form:input type="text" path="name" class="w-50 p-1 form-control form-control-sm"/>
				</div>
				<div class="d-flex justify-content-between form-group my-2">
					<form:errors class="text-warning" path="date" />
					<form:label path="date" class="text-dark">Fecha</form:label>
					<form:input type="date" path="date" class="w-50 p-1 form-control form-control-sm"/>
				</div>
				<div class="d-flex justify-content-between my-2">
					<form:errors class="text-warning" path="location" />
					<form:errors class="text-warning" path="state" />				
				</div>
				<div class="d-flex justify-content-between form-group my-2">
					<form:label path="state" class="text-dark">Ubicacion:</form:label>
					<div class="d-flex w-50">
						<form:input type="text" path="location" class="w-75 form-control form-control-sm"/>
						<form:select path="state" type="text" class="w-25 form-control">
							<c:forEach items="${states}" var="st">					
								<option>${st}</option>						
							</c:forEach>
						</form:select>
					</div>
				</div>					
					<input type="submit" value="Create event!" class="btn btn-dark"/>
			</form:form>
		</div>
		
	</div>
</body>
</html>