package br.edu.unisep.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.edu.unisep.hibernate.HibernateSessionFactory;
import br.edu.unisep.model.vo.TipoPokemonVO;

public class TipoPokemonDAO {

	public List<TipoPokemonVO> listar() {
		Session session = HibernateSessionFactory.getSession();
		
		Criteria crit = session.createCriteria(TipoPokemonVO.class);
		List<TipoPokemonVO> lista = crit.list();

		return lista;
	}
	
}
