<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="style.css">
		<meta charset="UTF-8">
		<title>Contúdos acadêmicos</title>
	</head>
	<body>
		
		<h1>Lista conteúdos</h1>
		<div class="content">
			<table>
				<thead>
					<th style="width: 35%">Disciplina</th>
					<th style="width: 20%">Título da aula</th>
					<th style="width: 15%">Data da aula</th>
					<th style="width: 15%"></th>
				</thead>
				<tbody>
					<c:forEach items="${listaConteudos}" var="conteudo">
						<tr>
							<td>${conteudo.disciplina.nome}</td>
							<td>${conteudo.titulo}</td>
							<td>
								<fmt:formatDate value="${conteudo.data}" pattern="dd/MM/yyyy"/>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<form action="novoConteudo" method="post">
				<input class="btn-submit" type="submit" value="Novo">
			</form>
		</div>
		
	</body>
</html>