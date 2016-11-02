package br.edu.unisep.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/enviarPost")
public class EnviarPostServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titulo = req.getParameter("titulo");
		String conteudo = req.getParameter("conteudo");

		req.setAttribute("titulo", titulo);
		req.setAttribute("conteudo", conteudo);

		RequestDispatcher rd = req.getRequestDispatcher("visualizadorPost.jsp");
		rd.forward(req, resp);
	}
}
