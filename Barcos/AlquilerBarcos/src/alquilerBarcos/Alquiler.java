package alquilerBarcos;

public class Alquiler {
	private String nombre;
	private String cedula;
	private int fechaini;
	private int fechafin;
	private int[] pamarre = new int[5];
	
	Barco barco = new Barco();
	
    public int DiasEntre(int fechaini , int fechafin){
        return fechafin - fechaini;
    }
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getFechaini() {
		return fechaini;
	}
	public void setFechaini(int fechaini) {
		this.fechaini = fechaini;
	}
	public int getFechafin() {
		return fechafin;
	}
	public void setFechafin(int fechafin) {
		this.fechafin = fechafin;
	}
	public int[] getPamarre() {
		return pamarre;
	}

	public void setPamarre(int[] pamarre) {
		this.pamarre = pamarre;
	}
	public int PosicionAmarre(int cont){
		for(int i=0; i<pamarre.length; i++){
			cont++;
		}
		return cont;
	}
	public float obtenerAlquiler(){
		return (float) (barco.obtenerFactor()*DiasEntre(fechafin, fechafin)*50.25);
	}
}
	
	

