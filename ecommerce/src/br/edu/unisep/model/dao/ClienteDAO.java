package br.edu.unisep.model.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import br.edu.unisep.hibernate.HibernateSessionFactory;
import br.edu.unisep.model.vo.ClienteVO;

public class ClienteDAO extends DAOGenerico<ClienteVO> {

	public ClienteVO obterCliente(String usuario, String senha) {
		Session session = HibernateSessionFactory.getSession();

		Criteria crit = session.createCriteria(ClienteVO.class);
		crit.add(Restrictions.eq("email", usuario));
		crit.add(Restrictions.eq("senha", senha));

		ClienteVO cliente = (ClienteVO) crit.uniqueResult();

		return cliente;
	}

	public boolean salvarCliente(ClienteVO cliente) {
		Session session = HibernateSessionFactory.getSession();

		Transaction t = session.beginTransaction();

		try {
			session.save(cliente);
			t.commit();
		} catch (ConstraintViolationException e) {
			t.rollback();
			return false;
		} finally {
			session.close();
		}

		return true;

	}

}
