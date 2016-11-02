package br.edu.unisep.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcular")
public class CalcularImcServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sexo = (String) req.getParameter("sexo");
		Double altura = Double.parseDouble((String) req.getParameter("altura"));
		Double peso = Double.parseDouble((String) req.getParameter("peso"));

		Double total = peso / Math.pow(altura, 2);
		String resultado;

		if (sexo == "F") {
			if (total < 20.7) {
				resultado = "Puro osso";
			} else if (total > 20.7 && total <= 26.4) {
				resultado = "Aí ta show";
			} else if (total > 26.4 && total <= 27.8) {
				resultado = "Ta com ovo na barriga";
			} else if (total > 27.8 && total <= 31.1) {
				resultado = "Sua gorda!";
			} else {
				resultado = "Seu gordo inútil, vai correr, larga o cheeseburguer!!";
			}

		} else {
			if (total < 19.1) {
				resultado = "Puro osso";
			} else if (total > 19.1 && total <= 25.8) {
				resultado = "Aí ta show";
			} else if (total > 25.8 && total <= 27.3) {
				resultado = "Ta com ovo na barriga";
			} else if (total > 27.3 && total <= 32.3) {
				resultado = "Sua gorda!";
			} else {
				resultado = "Seu gordo inútil, vai correr, larga o cheeseburguer!!";
			}
		}

		req.setAttribute("total", total);
		req.setAttribute("resultado", resultado);

		RequestDispatcher rd = req.getRequestDispatcher("MostrarResultado.jsp");
		rd.forward(req, resp);

	}
}
