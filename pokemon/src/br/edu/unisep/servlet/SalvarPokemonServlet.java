package br.edu.unisep.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unisep.model.dao.PokemonDAO;
import br.edu.unisep.model.vo.PokemonVO;
import br.edu.unisep.model.vo.TipoPokemonVO;

@WebServlet("/salvarPokemon")
public class SalvarPokemonServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String tipo = req.getParameter("tipo");
		String raridade = req.getParameter("raridade");
		
		String data = req.getParameter("dataDescoberta");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		PokemonVO pokemon = new PokemonVO();
		pokemon.setDescricao(nome);
		pokemon.setRaridade(Integer.valueOf(raridade));
		
		try {
			Date dataDescoberta = df.parse(data);
			pokemon.setDataDescoberta(dataDescoberta);
		} catch (ParseException e) {
			e.printStackTrace();	
		}

		TipoPokemonVO tipoPokemon = new TipoPokemonVO();
		tipoPokemon.setId(Integer.valueOf(tipo));
		
		pokemon.setTipo(tipoPokemon);
		
		PokemonDAO dao = new PokemonDAO();
		dao.salvar(pokemon);
		
		resp.sendRedirect("listarPokemon");
	}
	
}
