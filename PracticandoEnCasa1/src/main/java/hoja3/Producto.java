package hoja3;

public class Producto {

	private String libro;
	private int cantidad;
	
	public String getLibro() {
		return libro;
	}
	public void setLibro(String libro) {
		this.libro = libro;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Producto(String libro, int cantidad) {
		super();
		this.libro = libro;
		this.cantidad = cantidad;
	}
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
