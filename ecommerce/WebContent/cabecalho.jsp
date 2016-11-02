<div>
	<div style="display:inline-block; width:80%">
		<h3>E-Commerce</h3>
	</div>
	<div style="display:inline-block">
		<a href="visualizarCarrinho">
			Carrinho
			<c:if test="${qtdProdutosCarrinho != null}">
				(${qtdProdutosCarrinho} iten(s))
			</c:if>
		</a>
	</div>
</div>