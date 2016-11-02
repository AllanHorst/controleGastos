package br.edu.unisep.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/acessoRestrito")
public class AcessoRestritoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		if (s.getAttribute("dadosUsuario") != null) {
			resp.sendRedirect("restrito.jsp");
		} else {
			resp.sendRedirect("login.jsp");
		}
	}
}
