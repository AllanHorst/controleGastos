package br.edu.unisep.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.unisep.model.vo.ContaVO;
import br.edu.unisep.model.vo.UsuarioVO;
import br.edu.unisep.mongodb.dao.MongoDAO;
import br.edu.unisep.mongodb.factory.MongoDBSessionFactory;

public class UsuarioDAO extends MongoDAO<UsuarioVO> {

	public List<UsuarioVO> obterListaPorConta(String idConta) {
		Session session = MongoDBSessionFactory.getSession();
		Query q = session.createQuery("from " + UsuarioVO.class.getName() + " where conta.id = :ID ");
		q.setString("ID", idConta);
		
		ContaVO conta = (ContaVO) q.uniqueResult();
		session.close();
		if (conta == null) {
			return null;
		}
		return conta.getUsuarios();
	}
}
