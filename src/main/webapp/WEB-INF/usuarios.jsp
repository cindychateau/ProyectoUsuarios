<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>
		<c:out value="${titulo}" />
	</h1>
	
	<ul>
		<c:forEach var="usuario" items="${ listaUsuarios }">
			<li>
				<c:out value="${usuario.getNombre()}" /> <c:out value="${usuario.getApellido()}" />
			</li>
		</c:forEach>
	</ul>
	
	<c:forEach var="pais" items="${paises}">
		<h2>País: <c:out value="${pais.key}" /> - Capital: <c:out value="${pais.value}" /></h2>
	</c:forEach>
</body>
</html>