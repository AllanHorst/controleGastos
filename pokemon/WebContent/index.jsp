<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<link href="css/estilo.css" rel="stylesheet"> 
	<meta charset="UTF-8">
	<title>Pokemon</title>
</head>
<body>

	<h4>Lista de Pokemons</h4>
	
	<table border="1" style="width: 80%">
		<thead>
			<tr>
				<th style="width: 35%">Nome</th>
				<th style="width: 20%">Tipo</th>
				<th style="width: 15%">Raridade</th>
				<th style="width: 15%">Descoberta</th>
				<th style="width: 15%"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaPokemons}" var="p">
				<tr>
					<td>${p.descricao}</td>
					<td>${p.tipo.descricao}</td>
					<td>
						<c:choose>
							<c:when test="${p.raridade == 0}">
								Comum
							</c:when>						
							<c:when test="${p.raridade == 1}">
								Normal
							</c:when>
							<c:otherwise>
								Raro
							</c:otherwise>						
						</c:choose>
					</td>
					<td>
						<fmt:formatDate value="${p.dataDescoberta}" pattern="dd/MM/yyyy"/>
					</td>
					<td>
						<a href="excluirPokemon?id=${p.id}">Excluir</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form action="novo">
		<input type="submit" value="Novo" />
	</form>

</body>
</html>