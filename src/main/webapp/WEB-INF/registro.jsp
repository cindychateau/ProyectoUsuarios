<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
	<h1>Nuevo Usuario</h1>
	<form action="/registraUsuario" method="POST">
		<label for="nombre">Nombre:</label>
		<input type="text" name="nombre"><br>
		<label for="email">Email:</label>
		<input type="email" name="email"><br>
		<button type="button"></button>
		<input type="submit" value="Enviar">
	</form>
	<div>
		<c:forEach var="mensaje" items="${ error_registro }">
			<p><c:out value="${mensaje}" /></p>
		</c:forEach>
	</div>
</body>
</html>