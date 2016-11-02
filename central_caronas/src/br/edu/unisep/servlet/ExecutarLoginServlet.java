package br.edu.unisep.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.unisep.model.dao.UsuarioDAO;
import br.edu.unisep.model.vo.UsuarioVO;

@WebServlet("/executarLogin")
public class ExecutarLoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = (String) req.getParameter("login");
		String senha = (String) req.getParameter("senha");

		UsuarioDAO dao = new UsuarioDAO();
		UsuarioVO usuario = dao.pesquisarUsuario(login, senha);

		if (usuario == null) {
			req.setAttribute("erro_login", "Dados inválidos para o login");
			req.setAttribute("login", login);
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		} else {
			HttpSession session = req.getSession(true);
			session.setAttribute("usuario", usuario);
			resp.sendRedirect("restrito/listarCaronas");
		}

	}
}
