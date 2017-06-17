package logical;
import java.util.Date;

public class Ventas {
	
	private int codigoVenta;
	private double monto;	
	private String fecha;
	private Clientes clientes;
	private String producto;
	
	public Ventas(){
		super();
	}
	
	public int getCodigoVenta() {
		return codigoVenta;
	}
	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double d) {
		this.monto = d;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Clientes getClientes() {
		return clientes;
	}
	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}
	
}
