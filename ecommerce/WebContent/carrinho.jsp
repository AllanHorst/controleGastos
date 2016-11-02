<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>E-commerce</title>
	</head>
	<body>
		<!-- import cabecalho -->
		<c:import url="cabecalho.jsp"/>

		<!-- Carrinho de compras -->
		<h4>Carrinho de compras</h4>
		<c:choose>
			<c:when test="${itensCarrinho != null}">
				<table border="1">
					<thead>
						<tr>
							<th>Produto</th>
							<th>Quantidade</th>
							<th>Valor Unitário</th>
							<th>Total</th>
							<th>Remover</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${itensCarrinho}" var="item">
							<tr>
								<th>${item.produto.descricao}</th>
								<th>
									<a href="alterarQuantidade?idProduto=${item.produto.id}&operacao=1">-</a>		${item.quantidade}
									<a href="alterarQuantidade?idProduto=${item.produto.id}&operacao=2">+</a></th>
								</th>
								<th><fmt:formatNumber value="${item.valor}" type="currency" currencySymbol="R$"/></th>
								<th><fmt:formatNumber value="${item.quantidade * item.valor}" type="currency" currencySymbol="R$"/></th>
								<th><a href="removerItemCarrinho?idProduto=${item.produto.id}">Excluir</a></th>
							</tr>
						</c:forEach>
						<th>
							<td>
								<th>total</th>
							</td>
							<td>
								<fmt:formatNumber value="${totalCarrinho}" type="currency" currencySymbol="R$"/>
							</td>
						</th>
					</tbody>

				</table>
			</c:when>
			<c:otherwise>
				<p>Seu carrinho está vazio</p>
				<h5><a href="listarProdutos">Visualizar Produtos</a></h5>

			</c:otherwise>

		</c:choose>
		<h5><a href="listarProdutos">Continuar comprando</a></h5>
		<h5><a href="restrito/finalizacao.jsp">Finalizar compra</a></h5>
		
	</body>
</html>