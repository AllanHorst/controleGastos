package br.edu.unisep.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.unisep.vo.UsuarioVO;

@WebServlet("/executarLogin")
public class ExecutarLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		if (login.equals("admin") && senha.equals("admin")) {
			UsuarioVO user = new UsuarioVO();
			user.setLogin(login);
			user.setSenha(senha);
			user.setNome("Nome");

			HttpSession session = req.getSession(true);
			session.setAttribute("dadosUsuario", user);
			resp.sendRedirect("restrito.jsp");
		} else {
			req.setAttribute("msgErroLogin", "Errou..");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
	}
}
