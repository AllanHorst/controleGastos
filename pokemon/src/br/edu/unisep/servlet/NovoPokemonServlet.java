package br.edu.unisep.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unisep.model.dao.TipoPokemonDAO;
import br.edu.unisep.model.vo.TipoPokemonVO;

@WebServlet("/novo")
public class NovoPokemonServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TipoPokemonDAO dao = new TipoPokemonDAO();
		
		List<TipoPokemonVO> listaTipos = dao.listar();
		
		req.setAttribute("listaTipos", listaTipos);
	
		RequestDispatcher rd = req.getRequestDispatcher("novoPokemon.jsp");
		rd.forward(req, resp);
	}
	
}
