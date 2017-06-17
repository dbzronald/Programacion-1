package logical;

public abstract class Productos {

	protected String codigo;
	protected String nombre;
	protected double pcompra;
	protected int cantDias;
	protected int cantExistencia;
	
	public Productos(String codigo, String nombre, double pcompra,int cantDias, int cantExistencia) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.pcompra = pcompra;
		this.cantDias = cantDias;
		this.cantExistencia = cantExistencia;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPcompra() {
		return pcompra;
	}
	public void setPcompra(double pcompra) {
		this.pcompra = pcompra;
	}

	public double PrecioVenta(){
		return (pcompra*(cantDias/2));
	}
}
