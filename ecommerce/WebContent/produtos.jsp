<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>E-Commerce</title>
	<style>
		*{ margin: 0; padding: 0 }
	</style>
</head>
<body>

	<c:import url="cabecalho.jsp"/>

	<div>
		<a href="listarProdutos">Todos os Produtos</a>&nbsp;&nbsp;
		
		<c:forEach items="${categorias}" var="cat">
			<a href="listarProdutos?idCat=${cat.id}">${cat.descricao}</a>&nbsp;&nbsp;
		</c:forEach>
	</div>
	
	<table style="width: 80%" border="1">
		<thead>
			<tr>
				<th width="40%">Produto</th>
				<th width="30%">Categoria</th>
				<th width="20%">Valor</th>
				<th width="10%"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${produtos}" var="prod">
				<tr>
					<td>${prod.descricao}</td>
					<td>${prod.categoria.descricao}</td>
					<td style="text-align: right">
						<fmt:formatNumber value="${prod.valor}" type="currency"
							currencySymbol="R$ " />
					</td>
					<td style="text-align: center">
						<a href="adicionarCarrinho?idProduto=${prod.id}">Comprar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>