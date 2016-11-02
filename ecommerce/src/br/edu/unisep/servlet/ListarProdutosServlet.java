package br.edu.unisep.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unisep.model.dao.DAOGenerico;
import br.edu.unisep.model.dao.ProdutoDAO;
import br.edu.unisep.model.vo.CategoriaVO;
import br.edu.unisep.model.vo.ProdutoVO;

@WebServlet("/listarProdutos")
public class ListarProdutosServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DAOGenerico<CategoriaVO> daoCat = new DAOGenerico<>();
		List<CategoriaVO> categorias = daoCat.listar(CategoriaVO.class);
	
		String idCat = req.getParameter("idCat");
		
		List<ProdutoVO> produtos = null;
		ProdutoDAO daoProd = new ProdutoDAO();
		
		if (idCat == null) {
			// Indica que selecionou o link "Todos os Produtos" ou que está acessando
			// diretamente através da URL do navegador
			produtos = daoProd.listar(ProdutoVO.class);
		} else {
			// Indica que selecionou um dos links das categorias na tela inicial
			Integer cat = Integer.valueOf(idCat);
			produtos = daoProd.listar(cat);
		}
		
		req.setAttribute("categorias", categorias);
		req.setAttribute("produtos", produtos);

		RequestDispatcher rd = req.getRequestDispatcher("produtos.jsp");
		rd.forward(req, resp);
	}
	
}