package model;

public class Votacion {
    private String alumnos;
    private Integer numVotos;


    public Votacion(String alumnos) {
        this.alumnos = alumnos;
        this.numVotos = 0;  
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
