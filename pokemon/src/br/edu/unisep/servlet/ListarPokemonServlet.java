package br.edu.unisep.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unisep.model.dao.PokemonDAO;
import br.edu.unisep.model.vo.PokemonVO;

@WebServlet("/listarPokemon")
public class ListarPokemonServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PokemonDAO dao = new PokemonDAO();
		List<PokemonVO> listaPokemons = dao.listar();
		
		req.setAttribute("listaPokemons", listaPokemons);
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
	}
	
}
