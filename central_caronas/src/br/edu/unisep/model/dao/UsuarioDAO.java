package br.edu.unisep.model.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.edu.unisep.hibernate.HibernateSessionFactory;
import br.edu.unisep.model.vo.UsuarioVO;

public class UsuarioDAO extends DAOGenerico<UsuarioVO> {

	public UsuarioVO pesquisarUsuario(String login, String senha) {
		Session session = HibernateSessionFactory.getSession();

		Criteria c = session.createCriteria(UsuarioVO.class);
		c.add(Restrictions.eq("login", login));
		c.add(Restrictions.eq("senha", senha));

		UsuarioVO usuario = (UsuarioVO) c.uniqueResult();

		return usuario;
	}
}
