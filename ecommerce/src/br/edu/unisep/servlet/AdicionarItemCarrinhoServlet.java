package br.edu.unisep.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.unisep.model.dao.DAOGenerico;
import br.edu.unisep.model.vo.ItemPedidoVO;
import br.edu.unisep.model.vo.ProdutoVO;

@WebServlet("/adicionarCarrinho")
public class AdicionarItemCarrinhoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();

		Map<Integer, ItemPedidoVO> carrinho = (HashMap<Integer, ItemPedidoVO>) 
				session.getAttribute("carrinho");
		if (carrinho == null) {
			carrinho = new HashMap<>();
		}
		
		Integer idProduto = Integer.valueOf(req.getParameter("idProduto"));
		ItemPedidoVO item = carrinho.get(idProduto);
		
		if (item != null) {
			item.setQuantidade(item.getQuantidade() + 1);
		} else {
			DAOGenerico<ProdutoVO> dao = new DAOGenerico<>();
			ProdutoVO produto = dao.consultar(ProdutoVO.class, idProduto);
		
			item = new ItemPedidoVO();
			item.setProduto(produto);
			item.setValor(produto.getValor());
			item.setQuantidade(1);
		}
		
		carrinho.put(idProduto, item);
		
		session.setAttribute("carrinho", carrinho);
		session.setAttribute("qtdProdutosCarrinho", carrinho.size());
		
		resp.sendRedirect("listarProdutos");
		
	}
	
}