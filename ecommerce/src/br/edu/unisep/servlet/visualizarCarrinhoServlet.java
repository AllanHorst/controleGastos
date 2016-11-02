package br.edu.unisep.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.unisep.model.vo.ItemPedidoVO;

@WebServlet("/visualizarCarrinho")
public class visualizarCarrinhoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		Map<Integer, ItemPedidoVO> carrinho = (HashMap<Integer, ItemPedidoVO>) 
				session.getAttribute("carrinho");
		
		if(carrinho != null){
			List<ItemPedidoVO> itensCarrinho = new ArrayList<>();
			
			Double totalCarrinho = 0d;
			for(ItemPedidoVO item : carrinho.values()){
				totalCarrinho = totalCarrinho + item.getQuantidade() * item.getValor();
				itensCarrinho.add(item);
			}
			
			req.setAttribute("itensCarrinho", itensCarrinho);
			req.setAttribute("totalCarrinho", totalCarrinho);
			
			RequestDispatcher rd = req.getRequestDispatcher("carrinho.jsp");
			rd.forward(req, resp);
			
		}
	}
	
}
