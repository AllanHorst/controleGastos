<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
	</head>
	<body>
	<div>
		<div style="display:inline-block; width:80%">
			<h3>Central de caronas</h3>
		</div>
		<div style="display:inline-block">
			<span>Olá, ${usuario.login}</span>
			<a href="iniciarCarona">
			Nova Carona
			</a>
		</div>
	</div>
		
	<form action="salvarCarona" method="post">
		<select name="cidadeOrigem">
			<c:forEach items="${cidadesOrigem}" var="origem">
				<option value="${origem.id}">${origem.nome}</option>
			</c:forEach>
		</select> <br>

		<select name="cidadeDestino">
			<c:forEach items="${cidadesDestino}" var="destino">
				<option value="${destino.id}">${destino.nome}</option>
			</c:forEach>
		</select> <br>

		<input type="date" name="data"> <br>
		<input type="number" name="vagas">

		<input type="submit" value="Salvar">
	</form>

	</body>
</html>