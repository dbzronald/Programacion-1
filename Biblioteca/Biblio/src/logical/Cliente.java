package logical;

import java.util.ArrayList;

public class Cliente {
	private String id;
	private String nombre;
	private String dir;
	private ArrayList<Prestamo> prestamos;
	
	public Cliente(String id, String nombre, String dir) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dir = dir;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public void crearPrestamo(Prestamo nuevoPrestamo) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
