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
			<a href="novaCarona">
			Nova Carona
			</a>
		</div>
	</div>

		<form action="pesquisarCaronas" method="post">
			<select name="cidadeOrigem">
				<option></option>
				<c:forEach items="${cidadesOrigem}" var="origem">
					<option value="${origem.id}">${origem.nome}</option>
				</c:forEach>
			</select>

			<select name="cidadeDestino">
				<option></option>
				<c:forEach items="${cidadesDestino}" var="destino">
					<option value="${destino.id}">${destino.nome}</option>
				</c:forEach>
			</select>
			<input type="submit" value="Pesquisar">
		</form>

	<table style="width: 80%" border="1">
		<thead>
			<tr>
				<th width="20%">Origem</th>
				<th width="20%">Destino</th>
				<th width="20%">Motorista</th>
				<th width="10%">Data</th>
				<th width="10%">Vagas</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaCaronas}" var="carona">
				<tr>
					<td>${carona.cidadeOrigem.nome}</td>
					<td>${carona.cidadeDestino.nome}</td>
					<td>${carona.usuario.login}</td>
					<td style="text-align: right">
						<fmt:formatDate value="${carona.data}" pattern="dd/MM/yyyy"/>
					</td>
					<td>${carona.numeroVagas}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	</body>
</html>