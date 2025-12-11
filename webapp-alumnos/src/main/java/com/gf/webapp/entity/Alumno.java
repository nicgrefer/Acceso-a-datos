package com.gf.webapp.entity;

public class Alumno {

	private String Nombre;
	private String Apellido;
	private String Curso;
	private String Ciclo;
	
	public String getIdmatricula() {
		return Nombre.substring(0,2)+Apellido.substring(0,2);
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getCurso() {
		return Curso;
	}
	public void setCurso(String curso) {
		Curso = curso;
	}
	public String getCiclo() {
		return Ciclo;
	}
	public void setCiclo(String ciclo) {
		Ciclo = ciclo;
	}
	
	
	
}
