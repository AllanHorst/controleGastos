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

import br.edu.unisep.model.vo.ItemPedidoVO;

/**
 * Servlet implementation class RemoverItemCarrinhoServlet
 */
@WebServlet("/removerItemCarrinho")
public class RemoverItemCarrinhoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idProduto = Integer.valueOf(request.getParameter("idProduto"));
		
		HttpSession session = request.getSession();
		Map<Integer, ItemPedidoVO> carrinho = (HashMap<Integer, ItemPedidoVO>)
				session.getAttribute("carrinho");
		
		carrinho.remove(idProduto);
		session.setAttribute("qtdProdutosCarrinho", carrinho.size());
		response.sendRedirect("visualizarCarrinho");
	}

}
