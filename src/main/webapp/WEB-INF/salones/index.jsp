<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Salones</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nombre de la Clase</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${salones}">
					<tr>
						<td><c:out value="${s.getName()}"/></td>
						<td>
							<a href="/salon/${s.getId() }" class="btn btn-warning">Ver</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/dashboard">Regresar</a>
	</div>
</body>
</html>