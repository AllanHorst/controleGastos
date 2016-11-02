package br.edu.unisep.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.unisep.model.dao.CaronaDAO;
import br.edu.unisep.model.vo.CaronaVO;
import br.edu.unisep.model.vo.CidadeVO;
import br.edu.unisep.model.vo.UsuarioVO;

@WebServlet("/restrito/salvarCarona")
public class SalvarCaronaServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idOrigem = Integer.parseInt(req.getParameter("cidadeOrigem"));
		Integer idDestino = Integer.parseInt(req.getParameter("cidadeDestino"));
		Integer vagas = Integer.parseInt(req.getParameter("vagas"));
		Date data = null;
		try {
			DateFormat df = new SimpleDateFormat("yy-MM-dd");
			data = df.parse(req.getParameter("data"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		CidadeVO origem = new CidadeVO();
		origem.setId(idOrigem);
		CidadeVO destino = new CidadeVO();
		destino.setId(idDestino);

		HttpSession session = req.getSession();
		UsuarioVO usuario = (UsuarioVO) session.getAttribute("usuario");
		
		CaronaVO vo = new CaronaVO();
		vo.setCidadeOrigem(origem);
		vo.setCidadeDestino(destino);
		vo.setData(data);
		vo.setNumeroVagas(vagas);
		vo.setUsuario(usuario);

		CaronaDAO dao = new CaronaDAO();
		dao.salvar(vo);

		resp.sendRedirect("listarCaronas");
	}
}
