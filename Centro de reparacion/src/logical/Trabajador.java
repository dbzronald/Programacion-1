package logical;

public abstract class Trabajador {
	

	protected String cedula;
	protected String nombre;
	protected Double salarioDiario;
	protected int antiguedad;
	protected int cantDiasTrabajados;
	
	
	public Trabajador(){
	
		
	}
	
	
	public Trabajador(String cedula, String nombre, Double salarioDiario, int antiguedad,int cantDiasTrabajados) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.salarioDiario = salarioDiario;
		this.antiguedad = antiguedad;
		this.cantDiasTrabajados=cantDiasTrabajados;
	}


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


	public Double getSalarioDiario() {
		return salarioDiario;
	}


	public void setSalarioDiario(Double salarioDiario) {
		this.salarioDiario = salarioDiario;
	}


	public int getAntiguedad() {
		return antiguedad;
	}


	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}


	public int getCantDiasTrabajados() {
		return cantDiasTrabajados;
	}


	public void setCantDiasTrabajados(int cantDiasTrabajados) {
		this.cantDiasTrabajados = cantDiasTrabajados;
	}
	
	//Metodos
	
	public  abstract Double calcularSalarios(Double salarioDiario,int cantDiasTrabajados,int antiguedad);

	
	
	


}

