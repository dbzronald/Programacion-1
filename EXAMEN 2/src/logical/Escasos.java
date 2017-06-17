package logical;

public class Escasos extends Productos {
	
	private int incremento;
	
	
	public Escasos(String codigo, String nombre, double pcompra, int incremento,int cantDias, int cantExistencia) {
		super(codigo, nombre, pcompra,cantDias, cantExistencia);
		this.incremento = incremento;
		
	}

	public int getIncremento() {
		return incremento;
	}

	public void setIncremento(int incremento) {
		this.incremento = incremento;
	}
	
	public double PrecioVentaEsca(){
		return (PrecioVenta()*incremento)/100;
	}

}
