package logical;

import java.io.Serializable;

public class Partido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String Date;
	private String Home;
	private String Away;
	private String Locacion;
	private int PuntosHome;
	private int PuntosAway;
	private String Tiempo;
	private boolean Jugados;
	
	public Partido(String date, String home, String away, String locacion, int puntosHome, int puntosAway,
			String tiempo, boolean jugados) {
		super();
		Date = date;
		Home = home;
		Away = away;
		Locacion = locacion;
		PuntosHome = puntosHome;
		PuntosAway = puntosAway;
		Tiempo = tiempo;
		Jugados = jugados;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getHome() {
		return Home;
	}

	public void setHome(String home) {
		Home = home;
	}

	public String getAway() {
		return Away;
	}

	public void setAway(String away) {
		Away = away;
	}

	public String getLocacion() {
		return Locacion;
	}

	public void setLocacion(String locacion) {
		Locacion = locacion;
	}

	public int getPuntosHome() {
		return PuntosHome;
	}

	public void setPuntosHome(int puntosHome) {
		PuntosHome = puntosHome;
	}

	public int getPuntosAway() {
		return PuntosAway;
	}

	public void setPuntosAway(int puntosAway) {
		PuntosAway = puntosAway;
	}

	public String getTiempo() {
		return Tiempo;
	}

	public void setTiempo(String tiempo) {
		Tiempo = tiempo;
	}

	public boolean isJugados() {
		return Jugados;
	}

	public void setJugados(boolean jugados) {
		Jugados = jugados;
	}
	
	

}
