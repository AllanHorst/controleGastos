package br.edu.unisep.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unisep.dao.ConteudoDAO;
import br.edu.unisep.vo.ConteudoVO;

@WebServlet("/listarConteudos")
public class ListarConteudosServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ConteudoDAO dao = new ConteudoDAO();

		List<ConteudoVO> lista = dao.listar();

		req.setAttribute("listaConteudos", lista);

		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);

	}

}
