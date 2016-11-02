package br.edu.unisep.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.edu.unisep.hibernate.HibernateSessionFactory;
import br.edu.unisep.model.vo.ProdutoVO;

public class ProdutoDAO extends DAOGenerico<ProdutoVO> {

	public List<ProdutoVO> listar(Integer categoria) {
		Session session = HibernateSessionFactory.getSession();

		Criteria crit = session.createCriteria(ProdutoVO.class);
		crit.add(Restrictions.eq("categoria.id", categoria));

		List<ProdutoVO> retorno = crit.list();

		return retorno;
	}

}
