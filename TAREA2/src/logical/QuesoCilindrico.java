package logical;

public class QuesoCilindrico extends Quesos {
	private double longitud;
	
	public QuesoCilindrico(int precioBase, int precioUnitario, float longitud, int id,float radio) {
		super(precioBase, precioUnitario, radio ,id);
		this.longitud = longitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
	public float Volumen(){
		return (float) Math.round((Math.PI *  Math.pow(super.getRadio(), 2)));
		
	}
	
}
