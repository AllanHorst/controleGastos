package br.edu.unisep.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unisep.dao.ConteudoDAO;
import br.edu.unisep.vo.ConteudoVO;

@WebServlet("/salvarConteudo")
public class SalvarConteudoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titulo = req.getParameter("titulo");
		String descricao = req.getParameter("descricao");
		String data = req.getParameter("data");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		ConteudoVO vo = new ConteudoVO();
		vo.setTitulo(titulo);
		vo.setDescricao(descricao);
		try {
			Date dataConteudo = df.parse(data);
			vo.setData(dataConteudo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ConteudoDAO dao = new ConteudoDAO();
		dao.salvar(vo);
		
		resp.sendRedirect("listarConteudos");

	}

}
