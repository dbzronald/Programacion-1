package logical;

public class Deportista {
	private String nombre;
	private double peso;
	private double estatura;
	private boolean Sexo;
	
	// Constructor generado.
	
	public Deportista(String nombre, double peso, double estatura) {
		super();
		this.nombre = nombre;
		this.peso = peso;
		this.estatura = estatura;
		
	}
	
	//Gets and Sets generados.
	
	
	public String getNombre() {
		return nombre;
	}
	public boolean isSexo() {
		return Sexo;
	}

	public void setSexo(boolean string) {
		Sexo = string;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getEstatura() {
		return estatura;
	}
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	
	
}
