package bancopopular;

public class Clientes {
	private String cedula;
	private String nombre;
	private String direccion;
	private String telefono;
	private Cuentas cuenta;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Cuentas getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuentas cuenta) {
		this.cuenta = cuenta;
	}
	public void Retirar(){
		cuenta.setCodigo(15401629);
		cuenta.setCantidad_ret(400);
		
	}
	
	
	
	
}
