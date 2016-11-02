package br.edu.unisep;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/efetuarLogin")
public class EfetuarLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String usuario = (String) req.getParameter("usuario");
		String senha = (String) req.getParameter("senha");

		RequestDispatcher rd = null;
		if (usuario.equals("admin") && senha.equals("teste")) {
			
			req.setAttribute("usuario", usuario);
			req.setAttribute("senha", senha);

			rd = req.getRequestDispatcher("sucesso.jsp");
		} else {
			rd = req.getRequestDispatcher("incorreto.jsp");
		}

		rd.forward(req, resp);
	}
}
