package br.edu.unisep.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.edu.unisep.hibernate.HibernateSessionFactory;
import br.edu.unisep.model.vo.CaronaVO;

public class CaronaDAO extends DAOGenerico<CaronaVO> {

	public List<CaronaVO> pesquisarCarona(Integer idOrigem, Integer idDestino) {
		Session session = HibernateSessionFactory.getSession();

		Criteria c = session.createCriteria(CaronaVO.class);
		if (idOrigem != null) {
			c.add(Restrictions.eq("cidadeOrigem.id", idOrigem));
		}
		if (idDestino != null) {
			c.add(Restrictions.eq("cidadeDestino.id", idDestino));
		}

		List lista = c.list();

		return lista;
	}
}
