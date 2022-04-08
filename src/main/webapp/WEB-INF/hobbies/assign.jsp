<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	
	<div class="container">
		<h1>Asignar hobbies</h1>
		<h2><c:out value="${usuario.getFirst_name() }"/></h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Hobby</th>
					<th>Acción</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="hobby" items="${hobbies }">
					<tr>
						<td><c:out value="${hobby.getName() }"/></td>
						<td>
							<form action="/assign_hobby" method="post">
								<input type="hidden" name="user_id" value="${usuario.getId()}">
								<input type="hidden" name="hobby_id" value="${hobby.getId()}">
								<button type="submit" class="btn btn-success">Agregar Hobby</button> 
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
</body>
</html>