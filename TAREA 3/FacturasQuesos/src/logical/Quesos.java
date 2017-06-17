package logical;

import java.io.Serializable;

public abstract class Quesos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int precioBase;
	protected int precioUnitario;
	protected float radio;
	protected int id;
	
	public Quesos(int precioBase, int precioUnitario, float radio ,int id){
		super();
		this.precioBase = precioBase;
		this.precioUnitario = precioUnitario;
		this.radio = radio;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(int precioBase) {
		this.precioBase = precioBase;
	}

	public int getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public float getRadio() {
		return radio;
	}

	public void setRadio(float rad) {
		this.radio = rad;
	}
	public abstract float Volumen();
	
	public float precioTotal(float vol){
		return Math.round((precioBase + precioUnitario) * vol);

	}
		
}
