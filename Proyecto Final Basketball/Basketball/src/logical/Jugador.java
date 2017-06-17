package logical;

import java.io.Serializable;
import java.util.ArrayList;



public class Jugador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public static Jugador jugador;
	private String Nombre;
	private String Apellido;
	private int Edad;
	private int Peso;
	private int Pies;
	private int Pulgadas;
	private String Posicion;
	private String Nacimiento;
	private int Numero;
	private boolean Lesionado;
	private ArrayList<Lesion>Lesiones;
	private ArrayList<Estadisticas> estadisticasJugadores;
	private String Equipo;
	Liga liga;
	@SuppressWarnings("unused")
	private int PuntosTotales;
	
	
	public Jugador(String nombre, String apellido, int edad, int peso,int pies, int pulgadas, int numero, String posicion, String nacimiento, boolean lesionado, String equipo) {
		super();
		this.Nombre= nombre;
		this.Apellido= apellido;
		this.Edad = edad;
		this.Peso = peso;
		this.Pies = pies;
		this.Pulgadas = pulgadas;
		this.Posicion = posicion;
		this.Numero = numero;
		this.Nacimiento = nacimiento;
		this.Lesiones = new ArrayList<Lesion>();
		this.Lesionado = lesionado;

		this.estadisticasJugadores = new ArrayList<Estadisticas>();
		this.Equipo = equipo;
	}
	
	public Jugador() {
		estadisticasJugadores= new ArrayList<Estadisticas>();
		Lesiones = new ArrayList<Lesion>();
	}
	
public static Jugador getInstances(){
		
		if(jugador == null){
			jugador = new Jugador();
		}
		
		return jugador;
		
	}



public String getNombre() {
	return Nombre;
}


public void setNombre(String nombre) {
	Nombre = nombre;
}


public String getApellido() {
	return Apellido;
}


public void setApellido(String apellido) {
	Apellido =apellido;
}


public int getEdad() {
	return Edad;
}

public int getPeso() {
	return Peso;
}



public int getPies() {
	return Pies;
}



public int getPulgadas() {
	return Pulgadas;
}



public String getPosicion() {
	return Posicion;
}

public String getNacimiento() {
	return Nacimiento;
}


public void setNaciomiento(String nacimiento) {
	Nacimiento = nacimiento;
}

public void setPies(int pies) {
	Pies= pies;
}

public int getNumero() {
	return Numero;
}

public void setNumero(int numero) {
	Numero = numero;
}

public void setPosicion(String posicion) {
	Posicion = posicion;
}

public void InsertarLesion(Lesion lesion){
	
	Lesiones.add(lesion);
}


public ArrayList<Lesion> getLesiones() {
	return Lesiones;
}

public void setLesiones(ArrayList<Lesion> lesiones) {
	this.Lesiones = lesiones;
}

public ArrayList<Estadisticas> getEstadisticasJugadores() {
	return estadisticasJugadores;
}

public void setEstadisticasJugadores(
		ArrayList<Estadisticas> estadisticasJugadores) {
	this.estadisticasJugadores = estadisticasJugadores;
}

public void InsertarEstadisticasJugador(Estadisticas estadisticas) {
	estadisticasJugadores.add(estadisticas);
}

public boolean isLesionado() {
	return Lesionado;
}

public void setLesionado(boolean lesionado) {
	Lesionado = lesionado;
}

public String getEquipo() {
	return Equipo;
}

public void setEquipo(String equipo) {
	Equipo= equipo;
}

public int getPuntosTotales() {
	int total = 0;
	for (Equipo aux : Liga.getInstances().getEquipos()) {
		for (Jugador aux2 : aux.getJugadores()) {
			total += aux.getJugadores().get(0).getEstadisticasJugadores().get(0).getPuntos();
			
		}
	}
	return total;
}


}
