package br.edu.unisep.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

	private static SessionFactory factory;
	
	public static Session getSession() {
		
		if (factory == null) {
			Configuration config = new Configuration().configure();
			factory = config.buildSessionFactory();
		}
		
		return factory.openSession();
	}
}
