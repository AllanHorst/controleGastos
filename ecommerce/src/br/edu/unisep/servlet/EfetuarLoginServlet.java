package br.edu.unisep.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.unisep.model.dao.ClienteDAO;
import br.edu.unisep.model.vo.ClienteVO;

@WebServlet("/efetuarLogin")
public class EfetuarLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		ClienteDAO daoCliente = new ClienteDAO();
		ClienteVO cliente = daoCliente.obterCliente(login, senha);

		if (cliente != null) {
			HttpSession session = req.getSession();
			session.setAttribute("cliente", cliente);

			resp.sendRedirect("restrito/finalizarPedido");
		} else {
			req.setAttribute("erro_login", "Erro ao executar login.");
			req.setAttribute("login", login);

			RequestDispatcher rd = req.getRequestDispatcher("acesso.jsp");
			rd.forward(req, resp);
		}
	}
}
