package logical;

public class DeRiesgo extends Trabajador {

	private int index;

	public DeRiesgo() {

	}
	
	public DeRiesgo(String cedula, String nombre, Double salarioDiario, int antiguedad, int cantDiasTrabajados,int index) {
		super(cedula, nombre, salarioDiario, antiguedad, cantDiasTrabajados);
		if(index>0 && index<=5)
		this.index= index;	
	}
	

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

public Double calcularSalarios(Double salarioDiario, int cantDiasTrabajados, int antiguedad) {
	
		
		return (salarioDiario*cantDiasTrabajados)*((1/3) *antiguedad)*(index*5000);
	}

}
