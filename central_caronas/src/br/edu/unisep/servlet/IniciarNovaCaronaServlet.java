package br.edu.unisep.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unisep.model.dao.CidadeDAO;
import br.edu.unisep.model.vo.CidadeVO;

@WebServlet("/restrito/novaCarona")
public class IniciarNovaCaronaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CidadeDAO daoCidade = new CidadeDAO();
		List<CidadeVO> listaCidades = daoCidade.listar(CidadeVO.class);

		req.setAttribute("cidadesOrigem", listaCidades);
		req.setAttribute("cidadesDestino", listaCidades);

		RequestDispatcher rd = req.getRequestDispatcher("novaCarona.jsp");
		rd.forward(req, resp);

	}
}
