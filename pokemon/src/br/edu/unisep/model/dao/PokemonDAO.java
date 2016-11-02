package br.edu.unisep.model.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.edu.unisep.hibernate.HibernateSessionFactory;
import br.edu.unisep.model.vo.PokemonVO;

public class PokemonDAO {

	public List<PokemonVO> listar() {
		Session session = HibernateSessionFactory.getSession();
		Criteria crit = session.createCriteria(PokemonVO.class);
		
		List<PokemonVO> lista = crit.list();
		return lista;
	}
	
	public void salvar(PokemonVO pokemon) {
		Session session = HibernateSessionFactory.getSession();
		
		Transaction trans = session.beginTransaction();
		
		try { 
			session.save(pokemon);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
		session.close();
	}
	
	public void excluir(PokemonVO pokemon) {
		Session session = HibernateSessionFactory.getSession();
		
		Transaction trans = session.beginTransaction();
		
		try { 
			session.delete(pokemon);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}
		
		session.close();
	}
	
}
