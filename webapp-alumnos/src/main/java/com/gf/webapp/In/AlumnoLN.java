package com.gf.webapp.In;

import com.gf.webapp.dao.AlumnoDAO;
import com.gf.webapp.entity.Alumno;

public class AlumnoLN {

	public static String alta (Alumno al) throws Exception{
		
		if (AlumnoDAO.select(al)==null) {
			AlumnoDAO.insert(al);
			return "El alumno se ha guardado correctamente";
		}else {
			return "El usuario ya existe";
		}
		
		
	}
	
}
