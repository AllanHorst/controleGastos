package br.edu.unisep.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.unisep.hibernate.HibernateSessionFactory;
import br.edu.unisep.vo.ConteudoVO;

public class ConteudoDAO {

	public List<ConteudoVO> listar() {

		Session session = HibernateSessionFactory.getSession();

		Criteria c = session.createCriteria(ConteudoVO.class);

		return c.list();
	}

	public void salvar(ConteudoVO vo) {
		Session session = HibernateSessionFactory.getSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(vo);
			t.commit();
		} catch (Exception e) {
			t.rollback();
		}

		session.close();
	}
}
