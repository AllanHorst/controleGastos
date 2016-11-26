package br.edu.unisep.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.unisep.model.vo.ContaPagarReceberVO;
import br.edu.unisep.model.vo.UsuarioVO;
import br.edu.unisep.mongodb.dao.MongoDAO;
import br.edu.unisep.mongodb.factory.MongoDBSessionFactory;

public class ContaPagarReceberDAO extends MongoDAO<ContaPagarReceberVO> {

	public List<ContaPagarReceberVO> obterListaPorUsuario(String idUsuario) {
		Session session = MongoDBSessionFactory.getSession();
		Query q = session.createQuery("from " + UsuarioVO.class.getName() + " where id = :ID");
		q.setString("ID", idUsuario);

		UsuarioVO usuario = (UsuarioVO) q.uniqueResult();
		List<ContaPagarReceberVO> lista = usuario.getListaContasPagarReceber();
		if (lista == null) {
			lista = new ArrayList<ContaPagarReceberVO>();
		}
		session.close();

		return lista;
	}
}
