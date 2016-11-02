package br.edu.unisep.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.edu.unisep.hibernate.HibernateSessionFactory;
import br.edu.unisep.vo.DisciplinaVO;

public class DisciplinaDAO {

	public List<DisciplinaVO> listar() {

		Session session = HibernateSessionFactory.getSession();

		Criteria c = session.createCriteria(DisciplinaVO.class);

		return c.list();
	}

}
