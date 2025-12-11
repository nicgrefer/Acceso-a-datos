package com.gf.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gf.webapp.entity.Alumno;
import com.gf.webapp.resources.ConexionBD;

public class AlumnoDAO {
	
	public static int insert(Alumno al) throws SQLException, Exception {
		
		String sql = "INSERT INTO matriculas.alumnos VALUES(?,?,?,?,?)";
		try (Connection conn = ConexionBD.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, al.getIdmatricula());
			ps.setString(2, al.getNombre());
			ps.setString(3, al.getApellido());
			ps.setString(4, al.getCiclo());
			ps.setString(5, al.getCurso());
			
			// 1 -> operacion realizada | 2 -> operacion no se pudo realizar
			return ps.executeUpdate();
			
		}
				
	}
	
	public static int delet (Alumno al) throws SQLException, Exception {
		String sql = "DEPETE FROM matriculas.alumnos WHERE nMatriculas=?";
		try(Connection conn = ConexionBD.getConnection()){
					
			return 0;
		}
	}
	
	public static int update (Alumno al) throws SQLException, Exception{
		String sql = "UPDATE matriculas.alumnos SET ciclo=?,curso=? WHERE nMatricula=?";
		try (Connection conn = ConexionBD.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, al.getIdmatricula());
			ps.setString(2, al.getNombre());
			ps.setString(3, al.getApellido());
			ps.setString(4, al.getCiclo());
			ps.setString(5, al.getCurso());
			
			// 1 -> operacion realizada | 2 -> operacion no se pudo realizar
			return ps.executeUpdate();
			
		}
	}
	public static Alumno select (Alumno al) throws Exception{
		String sql = "SELECT * FROM matriculas.alumnos WHERE al.nMatricula=?";
		Alumno alumno = null;
		try(Connection conn = ConexionBD.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, al.getIdmatricula());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				alumno.setNombre(rs.getString(2));
				alumno.setApellido(rs.getString(3));
				alumno.setCiclo(rs.getString(4));
				alumno.setCurso(rs.getString(5));
			}	
			return alumno;
		}
	}

	public static boolean selectID(Alumno al) throws Exception{
		String sql = "SELECT * FROM matriculas.alumnos al WHERE al.nMatricula=?";
		boolean exist = false;
		try(Connection conn = ConexionBD.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, al.getIdmatricula());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				exist = true;
			}
		}
		return exist;
	}
	
}
