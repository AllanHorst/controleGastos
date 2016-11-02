package br.edu.unisep.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unisep.model.dao.CaronaDAO;
import br.edu.unisep.model.dao.CidadeDAO;
import br.edu.unisep.model.vo.CaronaVO;
import br.edu.unisep.model.vo.CidadeVO;

@WebServlet("/restrito/listarCaronas")
public class ListaCaronasServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CidadeDAO daoCidade = new CidadeDAO();
		List<CidadeVO> listaCidades = daoCidade.listar(CidadeVO.class);

		req.setAttribute("cidadesOrigem", listaCidades);
		req.setAttribute("cidadesDestino", listaCidades);

		CaronaDAO daoCarona = new CaronaDAO();
		List<CaronaVO> listaCaronas = daoCarona.listar(CaronaVO.class);

		req.setAttribute("listaCaronas", listaCaronas);

		RequestDispatcher rd = req.getRequestDispatcher("listaCaronas.jsp");
		rd.forward(req, resp);
	}
}
