package logical;

public class Clientes {
	private String nombre;
	private String apellido;
	private String cedula;
	private String telefono;
	private String direccion;
	
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
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String string) {
		this.cedula = string;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String string) {
		this.telefono = string;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
