package empresaDistribuidora;

public class Producto {
	private String nombre;
	private float codigo;
	private String tipo;
	private float precio_comp;
	private float precio_venta;
	private int dias_vencer;
	private int cantidadstock;
	private int cantidadinicial;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getCodigo() {
		return codigo;
	}
	public void setCodigo(float codigo) {
		this.codigo = codigo;
	}
	public String getTipo(String string) {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getPrecio_comp() {
		return precio_comp;
	}
	public void setPrecio_comp(float precio_comp) {
		this.precio_comp = precio_comp;
	}
	public float getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(float precio_venta) {
		this.precio_venta = precio_venta;
	}
	public int getDias_vencer() {
		return dias_vencer;
	}
	public void setDias_vencer(int dias_vencer) {
		this.dias_vencer = dias_vencer;
	}
	public int getCantidadstock() {
		return cantidadstock;
	}
	public void setCantidadstock(int cantidadstock) {
		this.cantidadstock = cantidadstock;
	}
	public int getCantidadinicial() {
		return cantidadinicial;
	}
	public void setCantidadinicial(int cantidadinicial) {
		this.cantidadinicial = cantidadinicial;
	}
	
}
