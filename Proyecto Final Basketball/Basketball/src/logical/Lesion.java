package logical;

import java.io.Serializable;

public class Lesion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String NombreCompleto;
	private String Equipo;
	private String Tipo;
	private String Date;
	private String Recuperacion;
	private String Observacion;
	
	public Lesion(String nombreCompleto, String equipo, String tipo, String date, String recuperacion) {
		super();
		NombreCompleto = nombreCompleto;
		Equipo = equipo;
		Tipo = tipo;
		Date = date;
		Recuperacion = recuperacion;
		
	}


	public String getNombreCompleto() {
		return NombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		NombreCompleto = nombreCompleto;
	}

	public String getEquipo() {
		return Equipo;
	}

	public void setEquipo(String equipo) {
		Equipo = equipo;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getRecuperacion() {
		return Recuperacion;
	}

	public void setRecuperacion(String recuperacion) {
		Recuperacion = recuperacion;
	}

	public String getObservacion() {
		return Observacion;
	}

	public void setObservacion(String observacion) {
		Observacion = observacion;
	}
	
	

}
