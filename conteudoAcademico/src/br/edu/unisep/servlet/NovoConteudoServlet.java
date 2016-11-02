package br.edu.unisep.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unisep.dao.DisciplinaDAO;
import br.edu.unisep.vo.DisciplinaVO;

@WebServlet("/novoConteudo")
public class NovoConteudoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DisciplinaDAO dao = new DisciplinaDAO();
		List<DisciplinaVO> lista = dao.listar();

		req.setAttribute("listaDisciplinas", lista);

		RequestDispatcher rd = req.getRequestDispatcher("novoConteudo.jsp");
		rd.forward(req, resp);
	}

}
