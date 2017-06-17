package logical;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int anFund;
	private String nombre;
	private ArrayList<Jugador> listaJugadores;
	
	
	
	public Equipo(int id, int anFund, String nombre, ArrayList<Jugador> listaJugadores) {
		super();
		this.id = id;
		this.anFund = anFund;
		this.nombre = nombre;
		this.listaJugadores = listaJugadores;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnFund() {
		return anFund;
	}

	public void setAnFund(int anFund) {
		this.anFund = anFund;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Jugador> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
