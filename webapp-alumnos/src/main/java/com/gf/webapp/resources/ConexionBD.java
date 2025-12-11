package com.gf.webapp.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	private static Connection conn = null;
	public static Connection getConnection() throws Exception {
		
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/matriculas/alumnos", "root", "");

	            if (conn != null) {
	                System.out.println("Conexion correcta a la base de datos");
	                return conn;
	            } else {
	                System.err.println("Conexion fallida");
	            }

	   } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            System.err.println("No se encontró el driver MySQL");
	  }
		 return null;
	}
	
}
