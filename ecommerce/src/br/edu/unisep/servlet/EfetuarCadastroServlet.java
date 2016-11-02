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

@WebServlet("/efetuarCadastro")
public class EfetuarCadastroServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		String endereco = req.getParameter("endereco");

		ClienteVO cliente = new ClienteVO();
		cliente.setEmail(email);
		cliente.setEndereco(endereco);
		cliente.setNome(nome);
		cliente.setSenha(senha);

		ClienteDAO daoCliente = new ClienteDAO();
		boolean criouCliente = daoCliente.salvarCliente(cliente);
		
		if (criouCliente) {
			HttpSession session = req.getSession();
			session.setAttribute("cliente", cliente);
			
			resp.sendRedirect("restrito/finalizarPedido");
		} else {
			req.setAttribute("cliente", cliente);
			req.setAttribute("erro_cadastro", "E-mail já cadastrado.");

			RequestDispatcher rd = req.getRequestDispatcher("acesso.jsp");

		}
		
		
	}
}
