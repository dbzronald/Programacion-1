package logical;

public class AltaGama extends Productos {
	
	private int calificador;
		
	public AltaGama(String codigo, String nombre, double pcompra, int calificador,int cantDias, int cantExistencia) {
		super(codigo, nombre, pcompra,cantDias, cantExistencia);
		this.calificador = calificador;
	}

	public int getCalificador() {
		return calificador;
	}

	public void setCalificador(int calificador) {
		this.calificador = calificador;
	}
	public double PrecioVentaAltaG(){
		return (PrecioVenta() + (calificador*50));
	}
	
}

