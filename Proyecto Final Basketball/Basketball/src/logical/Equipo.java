package logical;

import java.io.Serializable;
import java.util.ArrayList;


public class Equipo implements Serializable{
	
	public static Equipo equipo;
	static final long serialVersionUID = 1L;
	private String Nombre;
	private int Victorias;
	private int Derrotas;
	private String Coach;
	private String Locacion;
	private ArrayList<Estadisticas> EstadisticasEquipo;
	private ArrayList<Jugador> Jugadores;
	
	
	public Equipo(String nombre, int victorias, int derrotas, String coach, String locacion) {
		super();
		this.Nombre = nombre;
		this.Victorias = victorias;
		this.Derrotas = derrotas;
		this.Coach = coach;
		this.Locacion = locacion;
		this.EstadisticasEquipo = new ArrayList<Estadisticas>();
		
	}
	
	public Equipo(String nombre, String Coach, String locacion) {
		super();
		this.Nombre = nombre;
		this.Coach = Coach;
		this.Locacion = locacion;
		this.Jugadores = new ArrayList<Jugador>();
	}
	
	public Equipo() {
		super();
		Jugadores = new ArrayList<Jugador>();
		Nombre = "";
		Coach = "";
		Locacion = "";
		Jugadores = null;
	}
	
	
	public static Equipo getInstances(){
		
		if(equipo == null){
			equipo = new Equipo();
		}
		return equipo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getVictorias() {
		return Victorias;
	}

	public void setVictorias(int victorias) {
		Victorias = victorias;
	}

	public int getDerrotas() {
		return Derrotas;
	}

	public void setDerrotas(int derrotas) {
		Derrotas = derrotas;
	}
	
	public int getPuntos(int victorias, int derrotas) {
		return (victorias*(2)) + (derrotas*(1));
		
	}

	public double getPercentaje(int victorias, int derrotas) {
	return (double) victorias / (double) (victorias + derrotas);
		
	}

	public String getCoach() {
		return Coach;
	}

	public void setCoach(String Coach) {
		this.Coach = Coach;
	}

	public String getLocacion() {
		return Locacion;
	}
	
	public ArrayList<Jugador> getRostacion() {
		ArrayList<Jugador> Rostacion = null;
		
		for (Equipo aux : Liga.getInstances().getEquipos()) {
			for (Jugador aux2 : aux.getJugadores()) {
				Rostacion = aux.getJugadores();
				
			}
		}
		return Rostacion;
	}

	public void setRostacion(int Rostacion) {
	}

	public ArrayList<Estadisticas> getEstadisticasEquipos() {
		return EstadisticasEquipo;
	}

	public void setEstadisticasEquipo(ArrayList<Estadisticas> estadisticasEquipos) {
		EstadisticasEquipo = estadisticasEquipos;
	}

	public ArrayList<Jugador> getJugadores() {
		return Jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.Jugadores = jugadores;
	}
	
	public void InsertarJugador(Jugador jugador)
	{
		Jugadores.add(jugador);
	}
	
	public void InsertarEstadisticasEquipo(Estadisticas estadisticas) {
		EstadisticasEquipo.add(estadisticas);
	}

}
