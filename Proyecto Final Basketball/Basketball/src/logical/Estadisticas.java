package logical;

import java.io.Serializable;

public class Estadisticas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int Puntos;
	private int Rebotes;
	private int Asistencias;

	
	public Estadisticas(int puntos, int rebotes, int asistencias) {
		super();
		this.Puntos = puntos;
		this.Rebotes = rebotes;
		this.Asistencias = asistencias;

	}

	public int getPuntos() {
		return Puntos;
	}

	public void setPuntos(int puntos) {
		Puntos = puntos;
	}

	public int getRebotes() {
		return Rebotes;
	}

	public void setRebotes(int rebotes) {
		Rebotes = rebotes;
	}

	public int getAsistencias() {
		return Asistencias;
	}

	public void setAsistencias(int asistencias) {
		Asistencias = asistencias;
	}


	
	

}
