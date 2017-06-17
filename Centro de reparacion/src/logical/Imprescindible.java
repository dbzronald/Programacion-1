package logical;

public class Imprescindible extends Trabajador {


private Double incrementoSalario;


	public Double getIncrementoSalario() {
		return incrementoSalario;
	}

	public void setIncrementoSalario(Double incrementoSalario) {
		this.incrementoSalario = incrementoSalario;
	}
	
	public Double calcularSalarios(Double salarioDiario, int cantDiasTrabajados, int antiguedad) {
		
		return (salarioDiario*cantDiasTrabajados)*((1/3) *antiguedad)+incrementoSalario;
	}

	public Imprescindible(Double incrementoSalario) {
		super();
		this.incrementoSalario = incrementoSalario;
	}

}
