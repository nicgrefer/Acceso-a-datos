import java.io.Serializable;

public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String descripcion;
    
    public Tarea(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
    public String getId() {
        return id;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + " - Descripción: " + descripcion;
    }
}
