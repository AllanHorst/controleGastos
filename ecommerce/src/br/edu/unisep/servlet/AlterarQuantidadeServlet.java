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

@WebServlet("/alterarQuantidade")
public class AlterarQuantidadeServlet  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idProduto 	= Integer.valueOf(req.getParameter("idProduto"));
		Integer operacao 	= Integer.valueOf(req.getParameter("operacao"));
		
		HttpSession session = req.getSession();
		Map<Integer, ItemPedidoVO> carrinho = (HashMap<Integer, ItemPedidoVO>) 
				session.getAttribute("carrinho");
		
		ItemPedidoVO item = carrinho.get(idProduto);
		if(operacao == 1){
			item.setQuantidade(item.getQuantidade()-1);
			if(item.getQuantidade() == 0){
				session.setAttribute("qtdProdutosCarrinho", carrinho.size());
			}
		}else{
			item.setQuantidade(item.getQuantidade()+1);
		}
		
		resp.sendRedirect("visualizarCarrinho");
	}
}
