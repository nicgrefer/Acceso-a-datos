package model;

public class Votacion {

	private String alumnos;
	private Integer numVotos;
	
	public Votacion(String alumnos, Integer numVotos) {
		super();
		this.alumnos = alumnos;
		this.numVotos = numVotos;
	}

	public Votacion(String alumnos) {
		this.alumnos = alumnos;
	}

	public String getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(String alumnos) {
		this.alumnos = alumnos;
	}

	public Integer getNumVotos() {
		return numVotos;
	}

	public void setNumVotos() {
		numVotos++;
	}
	
	
	
}
