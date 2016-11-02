package br.edu.unisep.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unisep.model.dao.PokemonDAO;
import br.edu.unisep.model.vo.PokemonVO;

@WebServlet("/excluirPokemon")
public class ExcluirPokemonServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		PokemonVO pokemon = new PokemonVO();
		pokemon.setId(Integer.valueOf(id));
	
		PokemonDAO dao = new PokemonDAO();
		dao.excluir(pokemon);
		
		resp.sendRedirect("listarPokemon");
	}
	
}
