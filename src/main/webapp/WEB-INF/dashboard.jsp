<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<h1>¡Bienvenido al dashboard <c:out value="${nombre}"/> !</h1>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Email</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach var="usuario" items="${usuarios}">
				<tr>
					<td><c:out value="${usuario.getFirst_name()}" /></td>
					<td><c:out value="${usuario.getLast_name()}" /></td>
					<td><c:out value="${usuario.getEmail()}" /></td>
					<td>
						<form action="/delete/${usuario.getId()}" method="POST">
							<input type="hidden" name="_method" value="DELETE">
							<button type="submit" class="btn btn-danger">
								Eliminar
							</button>
						</form>
						<a href="/show/${usuario.getId()}" class="btn btn-warning">Ver</a>
						<a href="/asignar/${usuario.getId()}" class="btn btn-primary">Asignar Hobby</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<a href="/new" class="btn btn-primary">Agregar Usuario</a>
	<a href="/direcciones/new" class="btn btn-primary">Agregar Dirección</a>
</body>
</html>