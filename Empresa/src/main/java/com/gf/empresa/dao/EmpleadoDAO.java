package com.gf.empresa.dao;

import com.gf.empresa.entities.Empleados;
import com.gf.empresa.utils.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpleadoDAO {
	
	public static void insert(Empleados e) {
		try(Session sesion = HibernateUtils.getSessionFactory().openSession();){
			Transaction tr = sesion.beginTransaction();
			sesion.persist(e);
			tr.commit();
		}
	}

}
