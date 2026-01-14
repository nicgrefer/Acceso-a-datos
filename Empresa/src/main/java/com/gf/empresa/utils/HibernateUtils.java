package com.gf.empresa.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		try {

			Configuration config = new Configuration();
			config.configure().addResource("\\entidades\\Empleados.hbm.xml"); 
			config.configure().addResource("\\entidades\\Departamentos.hbm.xml");// Se configura Hibernate a partir del archivo
								// .cfg.xml
						ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			return config.buildSessionFactory(sr);
			// Se construye la SessionFactory
		} catch (Throwable ex) {
			System.err.println("No se pudo crear la SessionFactory:" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}