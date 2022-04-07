<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Dirección</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h1>Nueva Dirección</h1>
		
		<form:form action="/direcciones/create" method="POST" modelAttribute="direccion">
			
			<div class="form-group">
				<form:label path="street">Calle</form:label>
				<form:input path="street" class="form-control"/>
				<form:errors path="street"/>
			</div>
			
			<div class="form-group">
				<form:label path="number">Número</form:label>
				<form:input path="number" class="form-control"/>
				<form:errors path="number"/>
			</div>
			
			<div class="form-group">
				<form:label path="city">Ciudad</form:label>
				<form:input path="city" class="form-control"/>
				<form:errors path="city"/>
			</div>
			
			<div class="form-group">
				<form:label path="cp">Código Postal</form:label>
				<form:input path="cp" class="form-control"/>
				<form:errors path="cp"/>
			</div>
			
			<div class="form-group">
				<form:label path="country">País</form:label>
				<form:input path="country" class="form-control"/>
				<form:errors path="country"/>
			</div>
			
			<div class="form-group">
				<form:label path="usuario">Usuario</form:label>
				<form:select path="usuario" class="form-control">
					<c:forEach items="${usuarios_sindireccion}" var="u">
						<form:option value="${u.id}"> ${u.first_name} </form:option>
					</c:forEach>
				</form:select>
			</div>
			
			<button type="submit" class="btn btn-success">Guardar Direccion</button>
		</form:form>
	</div>

</body>
</html>