package codigoJava;

public class Persona {

	private String nombre;
	private String apellido;
	private int edad;
	private String contacto;
	
	// Constructores
	public Persona(String nombre, String apellido, int edad, String contacto) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.contacto = contacto;
	}
	
	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}


	//Getter y setter	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
	
	
	
}
