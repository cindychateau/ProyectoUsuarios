<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Muestra usuario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1><c:out value="${usuario.first_name}" /> <c:out value="${usuario.last_name}" /></h1>
		<p>
			E-mail: <c:out value="${usuario.email}" />
		</p>
		<p>
			Dirección: <c:out value="${usuario.direccion.getStreet()}" /> 
			<c:out value="${usuario.direccion.getNumber()}" /><br>
			<c:out value="${usuario.direccion.getCity()}" /> 
			<c:out value="${usuario.direccion.getCp()}" /> 
			<c:out value="${usuario.direccion.getCountry()}" />
		</p>
		<p>
			Hobbies:
		</p>
		<ul>
			<c:forEach var="hobby" items="${usuario.hobbies}">
			<li><c:out value="${hobby.getName()}"/></li>
			</c:forEach>
		</ul>
		<a href="/dashboard" class="btn btn-primary">Regresar</a>
	</div>
</body>
</html>